package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;

/**
 * @author : Cunho
 * @date : 2020/3/25
 * 관리자용 - 회원관리
 */
public interface MemberService {

    /**
     * 모든 회원리스트 반환
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse getUserList();

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

}
