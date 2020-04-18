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
        return memberService.getUserList();
    }

    @UserLoginToken
    @RequestMapping(value = "/list/name")
    public ServerResponse get_all_member_list_only_id_and_realname() {
        return memberService.getUserListOnlyIDAndRealname();
    }

    /**
     * 根据ID获取用户信息
     * @param userId
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ServerResponse<User> get_user_by_id(HttpSession session, @RequestParam("userId") Integer userId) {
        // 1. 로그인 세션 체크
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        // 2. 관리자 체크
        if (userService.checkAdminRole(user).isSuccess()) {
            return memberService.getUserById(userId);
        } else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
        }
    }

    /**
     * 删除用户
     * @param session
     * @param updateUser
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ServerResponse delete_member(HttpSession session, @RequestBody User updateUser) {
        // 1. 로그인 세션 체크
        User user = (User) session.getAttribute(Const.CURRENT_USER);

        // 2. 관리자 체크
        if (userService.checkAdminRole(user).isSuccess()) {
            return memberService.delete_member(updateUser);
        } else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
        }
    }

    /**
     * 회원정보 수정하기
     * @param updateUser
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/update")
    public ServerResponse<User> update_user_by_id(HttpSession session, @RequestBody User updateUser) {
        // 1. 로그인 체크
        User currentAdmin = (User) session.getAttribute(Const.CURRENT_USER);

        if (userService.checkAdminRole(currentAdmin).isSuccess()) {
            return memberService.updateUserById(updateUser);
        } else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
        }
    }

    /**
     * 启用/禁用
     * @param userId
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/update/status")
    public ServerResponse update_user_status(HttpSession session, @RequestParam("id") Integer userId) {
        // 1. 로그인 체크
        User currentAdmin = (User) session.getAttribute(Const.CURRENT_USER);

        if (userService.checkAdminRole(currentAdmin).isSuccess()) {
            return memberService.updateUserStatus(userId);
        } else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
        }
    }

    /**
     * 初始化密码
     * @param userId
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/update/reset/password")
    public ServerResponse<User> update_reset_password(HttpSession session, @RequestParam("id") Integer userId) {
        // 1. 로그인 체크
        User currentAdmin = (User) session.getAttribute(Const.CURRENT_USER);

        if (userService.checkAdminRole(currentAdmin).isSuccess()) {
            return memberService.resetPassword(userId);
        } else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
        }
    }



    /**
     * 신규회원 추가
     * @param user
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/create")
    public ServerResponse create(@RequestBody User user) {
        return userService.addUser(user);
    }

}
