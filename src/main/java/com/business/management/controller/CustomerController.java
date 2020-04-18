package com.business.management.controller;

import com.business.management.annotation.UserLoginToken;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.Customer;
import com.business.management.pojo.User;
import com.business.management.service.CustomerService;
import com.business.management.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author : Cunho
 * @date : 2020/3/25
 */
@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    /**
     * 고객리스트반환
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/list")
    public ServerResponse list() {
        return customerService.customerList();
    }

    /**
     * 아이디와 이름만 포함된 고객리스트 반환
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/list/name")
    public ServerResponse get_list_only_id_and_name() {
        return customerService.getCustomerListOnlyIDAndName();
    }

    /**
     * 고객상세정보 보기
     * @param customerId
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ServerResponse detail(@RequestParam(value = "customerId") Integer customerId) {

        return customerService.detail(customerId);
    }

    /**
     * 고객정보 Save
     * customerId가 없으면 새로 insert
     * customerId가 있으면 기존 아이디로 업데이트
     * @param customer
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ServerResponse create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @UserLoginToken
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServerResponse update(HttpSession session, @RequestBody Customer customer) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }

        // 1. 해당고객정보를 등록한자가 맞는지.. 혹은 최고관리자가 맞는지 체크..
        //    아니면 수정불가능
        if (user.getUsername().equals(customer.getAuthor()) || userService.checkAdminRole(user).isSuccess()) {
            return customerService.update(customer);
        }

        return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
    }






}
