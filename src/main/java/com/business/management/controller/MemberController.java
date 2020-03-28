package com.business.management.controller;

import com.business.management.annotation.UserLoginToken;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;
import com.business.management.service.MemberService;
import com.business.management.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author : Cunho
 * @date : 2020/3/25
 * 관리자 전용
 * 회원관리
 */
@Slf4j
@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private UserService userService;

    /**
     * 모든 회원 리스트 반환
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/list")
    public ServerResponse get_all_user_list() {
        // 1. 세션체크
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
//        }

        // 2. 관리자체크
        return memberService.getUserList();
//        if (userService.checkAdminRole(user).isSuccess()) {
//            return memberService.getUserList(pageNum, pageSize);
//        } else {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
//        }
    }

    /**
     * 根据ID获取用户信息
     * @param userId
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/detail/{userId}", method = RequestMethod.POST)
    public ServerResponse<User> get_user_by_id(@PathVariable("userId") Integer userId) {
        // 1. 로그인 세션 체크
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录， 请登陆管理员");
//        }

        // 2. 관리자 체크
        return memberService.getUserById(userId);
//        if (userService.checkAdminRole(user).isSuccess()) {
//            return memberService.getUserById(userId);
//        } else {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
//        }
    }

    /**
     * 회원정보 수정하기
     * @param updateUser
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/update")
    public ServerResponse<User> update_user_by_id(@RequestBody User updateUser) {
        // 1. 로그인 체크
//        User currentAdmin = (User) session.getAttribute(Const.CURRENT_USER);
//        if (currentAdmin == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录， 请登陆管理员");
//        }
        return memberService.updateUserById(updateUser);
//        if (userService.checkAdminRole(currentAdmin).isSuccess()) {
//            return memberService.updateUserById(updateUser);
//        } else {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
//        }
    }

    /**
     * 신규회원 추가
     * @param user
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/create")
    public ServerResponse create( User user) {
//        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
//        if (currentUser == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录， 请登陆管理员");
//        }
        // 2. 관리자 체크
        return userService.addUser(user);
//        if (userService.checkAdminRole(currentUser).isSuccess()) {
//            return userService.addUser(user);
//        } else {
//            // 3. 관리자가 아니면 등록못함.
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
//        }
    }


}
