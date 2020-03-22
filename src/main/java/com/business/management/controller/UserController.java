package com.business.management.controller;

import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;
import com.business.management.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author : Cunho
 * @date : 2020/3/22
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 사용자 로그인
     * @param session
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ServerResponse login(HttpSession session, String username, String password) {
        ServerResponse<User> response = userService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    /**
     * 신규 회원 추가
     * 관리자만 가능함
     * @param session
     * @param user
     * @return
     */
//    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ServerResponse create(HttpSession session, User user) {
        // 1. 로그인 체크
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录， 请登陆管理员");
        }
        // 2. 관리자 체크
        if (userService.checkAdminRole(currentUser).isSuccess()) {
            return userService.addUser(user);
        } else {
            // 3. 관리자가 아니면 등록못함.
            return ServerResponse.createByErrorMessage("无权限操作");
        }
    }

}
