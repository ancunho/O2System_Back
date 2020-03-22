package com.business.management.dao;

import com.business.management.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component("userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * username존재여부 체크
     * @param username
     * @return
     */
    int checkUsername(String username);

    /**
     * 로그인 정보 가져오기
     * @param username
     * @param password
     * @return
     */
    User selectLogin(@Param("username") String username, @Param("password")String password);

    /**
     * 관리자 username 체크
     * @param username
     * @param role
     * @return
     */
    int checkAdminUsername(@Param("username") String username, @Param("role") Integer role);

    /**
     * Email체크
     * email은 유일해야함.
     * @param email
     * @return
     */
    int checkEmail(String email);

}