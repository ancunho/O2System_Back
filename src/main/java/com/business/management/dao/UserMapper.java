package com.business.management.dao;

import com.business.management.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


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

    /**
     * 이메일 중복체크
     * 이 사용자를 제외한 그 외 데이타중
     * @param email
     * @param userId
     * @return
     */
    int checkEmailByUserId(@Param(value="email") String email, @Param(value="userId") Integer userId);

    /**
     * username을 통해 물음 가져오기
     * @param username
     * @return
     */
    String selectQuestionByUsername(String username);

    /**
     * 답안이 맞는지 체크
     * @param username
     * @param question
     * @param answer
     * @return
     */
    int checkAnswer(@Param("username") String username, @Param("question") String question,@Param("answer") String answer);

    /**
     * 비밀번호 변경
     * @param username
     * @param passwordNew
     * @return
     */
    int updatePasswordByUsername(@Param("username") String username, @Param("passwordNew") String passwordNew);

    /**
     * 비밀번호 정확여부 체크
     * @param password
     * @param userId
     * @return
     */
    int checkPassword(@Param(value="password") String password, @Param("userId") Integer userId);


    List<User> selectAllUser();

    List<User> getUserListOnlyIDAndRealname();

    int updateAvatarPath(User user);



}