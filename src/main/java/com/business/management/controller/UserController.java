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
import org.springframework.web.bind.annotation.RequestParam;
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
     * 로그아웃
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ServerResponse logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessMessage("已成功退出");
    }

    /**
     * 개인정보 조회
     * @param session
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public ServerResponse info(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "请先登陆");
        }
        return userService.getInformation(user.getId());
    }

    /**
     * 개인정보 수정
     * @param session
     * @param user
     * @return
     */
    @RequestMapping(value = "/info/update", method = RequestMethod.POST)
    public ServerResponse info_update(HttpSession session, User user) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "请先登陆");
        }
        // 1. 현재 로그인한 사용자 정보 세팅
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        // 2. 정보 업데이트
        ServerResponse<User> response = userService.updateInformation(user);
        // 3. 세션업데이트
        if (response.isSuccess()) {
            response.getData().setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }

        return response;
    }


    /**
     * 找回密码 3 - 1
     * username을 통해 물음 가져오기
     * @param username
     * @return
     */
    @RequestMapping(value = "/forget_get_question", method = RequestMethod.POST)
    public ServerResponse<String> forgetGetQuestion(String username) {
        return userService.selectQuestion(username);
    }

    /**
     * 找回密码 3 - 2
     * 답안 체크 및 token반환
     * @param username
     * @param question
     * @param answer
     * @return
     */
    @RequestMapping(value = "/forget_check_answer", method = RequestMethod.POST)
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
        return userService.checkAnswer(username,question,answer);
    }

    /**
     * 找回密码 3 - 3
     * 새 비밀번호 저장
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    @RequestMapping(value = "/forget_reset_password", method = RequestMethod.POST)
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) {
        return userService.forgetResetPassword(username, passwordNew, forgetToken);
    }

    /**
     * 비밀번호 수정
     * @param session
     * @param passwordOld
     * @param passwordNew
     * @return
     */
    @RequestMapping(value = "/update/password", method = RequestMethod.POST)
    public ServerResponse<String> reset_password(HttpSession session, String passwordOld, String passwordNew) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "请先登陆");
        }

        return userService.resetPassword(passwordOld, passwordNew, user);
    }

    /**
     * 신규 회원 추가
     * @param user
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ServerResponse create(User user) {
        return userService.addUser(user);
        /***************************************************************************************
        // 1. 로그인 체크
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录， 请登陆管理员");
        }
        // 2. 관리자 체크
        if (userService.checkAdminRole(currentUser).isSuccess()) {

        } else {
            // 3. 관리자가 아니면 등록못함.
            return ServerResponse.createByErrorMessage("无权限操作");
        }
        ****************************************************************************************/
    }

}
