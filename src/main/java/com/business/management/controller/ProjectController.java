package com.business.management.controller;

import com.business.management.annotation.PassToken;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;
import com.business.management.service.CustomerService;
import com.business.management.service.MemberService;
import com.business.management.service.ProjectBaseinfoService;
import com.business.management.service.UserService;
import com.business.management.util.ValueUtil;
import com.business.management.vo.ProjectBaseinfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author : Cunho
 * @date : 2020/4/15
 */
@Slf4j
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProjectBaseinfoService projectBaseinfoService;

    @PassToken
    @RequestMapping(value = "/save/baseinfo", method = RequestMethod.POST)
    public ServerResponse save_baseinfo(HttpSession session, @RequestBody ProjectBaseinfoVO projectBaseinfoVO) {
//        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
//        if (currentUser == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
//        }
        ServerResponse response = projectBaseinfoService.save(projectBaseinfoVO);
        if (response.isSuccess()) {

        }

        return null;
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println(ValueUtil.isEmpty());
//    }

}
