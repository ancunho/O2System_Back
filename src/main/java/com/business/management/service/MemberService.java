package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : Cunho
 * @date : 2020/3/25
 * 관리자용 - 회원관리
 */
public interface MemberService {

    /**
     * 모든 회원리스트 반환
     * @return
     */
    ServerResponse getUserList();

    /**
     * 只返回ID和名字
     * @return
     */
    ServerResponse getUserListOnlyIDAndRealname();

    /**
     * userId로 회원 상세정보 가져온다.
     * @param userId
     * @return
     */
    ServerResponse<User> getUserById(Integer userId);

    /**
     *  회원정보 수정하기
     * @param updateUser
     * @return
     */
    ServerResponse<User> updateUserById(User updateUser);

    /**
     * 회원활성화 / 비활성화 변경
     * @param userId
     * @return
     */
    ServerResponse updateUserStatus(Integer userId);

    /**
     *
     * @param user
     * @return
     */
    ServerResponse<String> delete_member(@RequestParam(value = "id") Integer userId);

    /**
     * 初始化密码
     * @param userId
     * @return
     */
    ServerResponse resetPassword(Integer userId);



}
