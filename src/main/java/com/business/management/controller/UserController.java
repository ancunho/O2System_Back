package com.business.management.controller;

import com.business.management.annotation.PassToken;
import com.business.management.annotation.UserLoginToken;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;
import com.business.management.service.UserService;
import com.business.management.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Cunho
 * @date : 2020/3/22
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 로그인
     * @param username
     * @param password
     * @return
     */
    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ServerResponse login(HttpSession session, String username, String password) {
        User currentUser = userService.login(username, password);

        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户名或者密码错误");
        }

        String token = TokenUtil.createToken(currentUser);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        session.setAttribute(Const.CURRENT_USER, currentUser);

        return ServerResponse.createBySuccess(map);
    }

    /**
     * 로그아웃
     * @param session
     * @return
     */
    @PassToken
    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessMessage("已成功退出");
    }

    /**
     * 개인정보 조회
     * @param token
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse info(HttpSession session, @RequestHeader("Access-Token") String token) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null){
            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getDesc());
        }
        return userService.info(token);
    }

    /**
     * 개인정보 수정
     * @param session
     * @param user
     * @return
     */
    @UserLoginToken
    @RequestMapping(value = "/info/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse info_update(HttpSession session, @RequestBody User user) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
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
    @PassToken
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
    @PassToken
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
    @PassToken
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
    @UserLoginToken
    @RequestMapping(value = "/update/password", method = RequestMethod.POST)
    public ServerResponse<String> reset_password(HttpSession session, String passwordOld, String passwordNew) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "请先登陆");
        }

        return userService.resetPassword(passwordOld, passwordNew, user);
    }

    /**
     * 회원가입
     * @param user
     * @return
     */
    @PassToken
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ServerResponse create(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * username 중복체크
     * 회원가입할때 혹은 관리자가 username수정할때 사용
     * @param username
     * @return
     */
    @PassToken
    @RequestMapping(value = "/check_username", method = RequestMethod.POST)
    public ServerResponse check_username(String username) {
        return userService.checkValid(username, Const.USERNAME);
    }

    /**
     * Email 중복체크
     * 회원가입할때 혹은 관리자가 email 수정할때 사용
     * @param email
     * @return
     */
    @PassToken
    @RequestMapping(value = "/check_email", method = RequestMethod.POST)
    public ServerResponse check_email(String email) {
        return userService.checkValid(email, Const.EMAIL);
    }


    /*********************************************************************************************************
     * 												관리자 전용
     *********************************************************************************************************/

    @UserLoginToken
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ServerResponse delete_user(HttpSession session, @RequestBody User user) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "请先登陆");
        }

        return userService.delete_user(user);
    }



}
