package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;

/**
 * @author : Cunho
 * @date : 2020/3/22
 */
public interface UserService {

    /**
     * 로그인
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    ServerResponse<User> info(String token);

    /**
     * 관리자체크기능
     * Role == 1
     * @param user
     * @return
     */
    ServerResponse checkAdminRole(User user);

    /**
     * 내정보 가져오기 - 로그인상태임
     * @param userId
     * @return
     */
    ServerResponse<User> getInformation(Integer userId);

    /**
     * userId로 User가져오기
     * @param userId
     * @return
     */
    User findUserById(Integer userId);

    /**
     * 개인정보 수정
     * @param user
     * @return
     */
    ServerResponse<User> updateInformation(User user);

    /**
     * 신규회원추가 - 모든 회원 등록가능
     * @param user
     * @return
     */
    ServerResponse<String> addUser(User user);

    /**
     * 검증기능
     * @param str : 검증하려는 string
     * @param type : 'username' / 'email'
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 물음 가져오기 3-1 단계 : 해당 username을 통해 비번찾기
     * @param username
     * @return
     */
    ServerResponse<String> selectQuestion(String username);

    /**
     * 물음 가져오기 3-2 단계 : 답안이 맞는지 체크
     * @param username
     * @param question
     * @param answer
     * @return
     */
    ServerResponse<String> checkAnswer(String username,String question,String answer);

    /**
     *
     * @param username
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    ServerResponse updateUserAvatarImagePath(User user);

    /*********************************************************************************************************
     * 												관리자 전용
     *********************************************************************************************************/

    ServerResponse<String> delete_user(User user);

}
