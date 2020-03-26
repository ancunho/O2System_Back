package com.business.management.controller;

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
     * @param session
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ServerResponse get_all_user_list(HttpSession session
                                        ,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum
                                        ,@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        // 1. 세션체크
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
        }

        // 2. 관리자체크
        if (userService.checkAdminRole(user).isSuccess()) {
            return memberService.getUserList(pageNum, pageSize);
        } else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
        }
    }

    /**
     * 根据ID获取用户信息
     * @param session
     * @param userId
     * @return
     */
    @RequestMapping(value = "/detail/{userId}", method = RequestMethod.POST)
    public ServerResponse<User> get_user_by_id(HttpSession session, @PathVariable("userId") Integer userId) {
        // 1. 로그인 세션 체크
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录， 请登陆管理员");
        }

        // 2. 관리자 체크
        if (userService.checkAdminRole(user).isSuccess()) {
            return memberService.getUserById(userId);
        } else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
        }
    }

    /**
     * 회원정보 수정하기
     * @param session
     * @param updateUser
     * @return
     */
    @RequestMapping(value = "/update")
    public ServerResponse<User> update_user_by_id(HttpSession session, @RequestBody User updateUser) {
        // 1. 로그인 체크
        User currentAdmin = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentAdmin == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录， 请登陆管理员");
        }

        if (userService.checkAdminRole(currentAdmin).isSuccess()) {
            return memberService.updateUserById(updateUser);
        } else {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
        }
    }

    /**
     * 신규회원 추가
     * @param session
     * @param user
     * @return
     */
    @RequestMapping(value = "/create")
    public ServerResponse create(HttpSession session, User user) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录， 请登陆管理员");
        }
        // 2. 관리자 체크
        if (userService.checkAdminRole(currentUser).isSuccess()) {
            return userService.addUser(user);
        } else {
            // 3. 관리자가 아니면 등록못함.
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NO_PERMISSION.getCode(), ResponseCode.NO_PERMISSION.getDesc());
        }
    }


}
