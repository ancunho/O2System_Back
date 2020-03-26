package com.business.management.controller;

import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.Customer;
import com.business.management.pojo.User;
import com.business.management.service.CustomerService;
import com.business.management.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * @param session
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    public ServerResponse list(HttpSession session
            , @RequestParam(value = "pageNum", defaultValue = "1") int pageNum
            , @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }

        return customerService.customerList(pageNum, pageSize);
    }

    /**
     * 고객상세정보 보기
     * @param session
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ServerResponse detail(HttpSession session, @RequestParam(value = "customerId") Integer customerId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }

        return customerService.detail(customerId);
    }

    /**
     * 고객정보 Save
     * customerId가 없으면 새로 insert
     * customerId가 있으면 기존 아이디로 업데이트
     * @param session
     * @param customer
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ServerResponse create(HttpSession session, Customer customer) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }

        return customerService.create(customer);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServerResponse update(HttpSession session, Customer customer) {
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
