package com.business.management.service.impl;

import com.auth0.jwt.JWT;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.common.TokenCache;
import com.business.management.dao.UserMapper;
import com.business.management.pojo.User;
import com.business.management.service.UserService;
import com.business.management.util.MD5Util;
import com.business.management.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : Cunho
 * @date : 2020/3/22
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        return userMapper.selectLogin(username, md5Password);

    }

    @Override
    public ServerResponse<User> info(String token) {
        Integer userId = TokenUtil.getUserIdByToken(token);

        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return ServerResponse.createByErrorMessage("找不到用户");
        }

        return ServerResponse.createBySuccess(user);
    }

    @Override
    public ServerResponse checkAdminRole(User user) {
        if (user != null && user.getRole().equals(Const.Role.ROLE_ADMIN)) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    @Override
    public ServerResponse<User> getInformation(Integer userId) {
        // 1. ID로 해당유저 정보 가져옴
        User user = userMapper.selectByPrimaryKey(userId);
        // 2. 없으면 에러 반환
        if (user == null) {
            return ServerResponse.createByErrorMessage("找不到当前用户");
        }
        // 3. 비밀번호 공백처리후 데이타 반환
        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);
    }

    @Override
    public User findUserById(Integer userId) {
        // 1. ID로 해당유저 정보 가져옴
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public ServerResponse<User> updateInformation(User user) {
        // 0. username(로그인아이디)는 수정될수 없다.
        // 1. email체크
        int resultCount = userMapper.checkEmailByUserId(user.getEmail(), user.getId());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("email已存在,请更换email再尝试更新");
        }

        // 2. update할 새로운 오브젝트 생성(username빼고)
        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setEmpno(user.getEmpno());
        updateUser.setRealname(user.getRealname());
        updateUser.setPhone(user.getPhone());
        updateUser.setEmail(user.getEmail());
        updateUser.setDepartment(user.getDepartment());
        updateUser.setSex(user.getSex());
        updateUser.setBirthday(user.getBirthday());
        updateUser.setWechat(user.getWechat());
        updateUser.setQq(user.getQq());
        updateUser.setProvince(user.getProvince());
        updateUser.setCity(user.getCity());
        updateUser.setArea(user.getArea());
        updateUser.setAddress(user.getAddress());
        updateUser.setQuestion(user.getQuestion());
        updateUser.setAnswer(user.getAnswer());
        updateUser.setImagePhoto(user.getImagePhoto());
        updateUser.setParam1(user.getParam1());
        updateUser.setParam2(user.getParam2());
        updateUser.setParam3(user.getParam3());
        updateUser.setParam4(user.getParam4());
        updateUser.setParam5(user.getParam5());

        // 3. update 진행
        int updateCount = userMapper.updateByPrimaryKeySelective(updateUser);
        if (updateCount > 0) {
            return ServerResponse.createBySuccess("更新个人信息成功", updateUser);
        }
        return ServerResponse.createByErrorMessage("更新个人信息失败");
    }

    @Override
    public ServerResponse<String> addUser(User user) {
        // 1. username이 중복인지 체크한다.
        ServerResponse validResponse = this.checkValid(user.getUsername(), Const.USERNAME);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }
        // 2. email이 중복인지 체크한다.
        validResponse = this.checkValid(user.getEmail(), Const.EMAIL);
        if (!validResponse.isSuccess()) {
            return validResponse;
        }
        // 3. 기본 권한을 일반사용자로 한다.
        user.setRoleNo(Const.RoleNo.ROLE_USER);
        // 4. 값 => 0
        user.setRole(Const.Role.ROLE_USER);
        // 5. default-> 활성화
        user.setStatus(Const.Status.ACTIVE);
        // 4. 비밀번호를 MD5로 바꾼다.
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        // 5. user모델 저장 - 회원 신규등록
        int resultCount = userMapper.insert(user);
        // 6. 5에서 insert가 실행이 안되면 0을 반환.그럼 실패
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("新增用户失败");
        }
        // 7. 0이 아닌 반환값 > 0이면 성공 ---- 성공햇다는것만 반환한다.
        return ServerResponse.createBySuccessMessage("新增用户成功");
    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(type)) {
            //用户名校验
            if (Const.USERNAME.equals(type)) {
                int resultCount = userMapper.checkUsername(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在，请使用其他用户名");
                } else {
                    return ServerResponse.createBySuccessMessage("用户名不存在，可以使用");
                }
            } else if (Const.EMAIL.equals(type)) {
                int resultCount = userMapper.checkEmail(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("Email已存在，请使用其他Email");
                } else {
                    return ServerResponse.createBySuccessMessage("可以使用");
                }
            } else {
                return ServerResponse.createByErrorMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
            }

        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
//        return ServerResponse.createBySuccessMessage("校验成功");
    }

    @Override
    public ServerResponse<String> selectQuestion(String username) {
        // 1. 파라미터에서 넘어온 username이 존재하는지 검증
        ServerResponse validResponse = this.checkValid(username, Const.USERNAME);
        if (validResponse.isSuccess()) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }

        // 2. 해당 username 물음 가져옴
        String question = userMapper.selectQuestionByUsername(username);
        // 3. 공백인지 체크
        if (org.apache.commons.lang3.StringUtils.isNotBlank(question)) {
            return ServerResponse.createBySuccess(question);
        }

        return ServerResponse.createBySuccessMessage("找回密码的问题是空的");
    }

    @Override
    public ServerResponse<String> checkAnswer(String username, String question, String answer) {
        int resultCount = userMapper.checkAnswer(username, question, answer);
        if (resultCount > 0) {
            //说明问题及问题答案是这个用户的,并且是正确的
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX + username, forgetToken);
            return ServerResponse.createBySuccess(forgetToken);
        }
        return ServerResponse.createByErrorMessage("问题的答案错误");
    }


    @Override
    public ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken) {
        if (org.apache.commons.lang3.StringUtils.isBlank(forgetToken)) {
            return ServerResponse.createByErrorMessage("参数错误,token需要传递");
        }
        ServerResponse validResponse = this.checkValid(username, Const.USERNAME);
        if (validResponse.isSuccess()) {
            //用户不存在
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX + username);
        if (org.apache.commons.lang3.StringUtils.isBlank(token)) {
            return ServerResponse.createByErrorMessage("token无效或者过期");
        }

        if (org.apache.commons.lang3.StringUtils.equals(forgetToken, token)) {
            String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
            int rowCount = userMapper.updatePasswordByUsername(username, md5Password);

            if (rowCount > 0) {
                return ServerResponse.createBySuccessMessage("修改密码成功");
            }
        } else {
            return ServerResponse.createByErrorMessage("token错误,请重新获取重置密码的token");
        }
        return ServerResponse.createByErrorMessage("修改密码失败");
    }

    @Override
    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user) {
        //防止横向越权,要校验一下这个用户的旧密码,一定要指定是这个用户.因为我们会查询一个count(1),如果不指定id,那么结果就是true啦count>0;
        int resultCount = userMapper.checkPassword(MD5Util.MD5EncodeUtf8(passwordOld), user.getId());
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("旧密码错误");
        }

        user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("密码更新成功");
        }
        return ServerResponse.createByErrorMessage("密码更新失败");
    }


    /*********************************************************************************************************
     * 												관리자 전용
     *********************************************************************************************************/

    @Override
    public ServerResponse<String> delete_user(User user) {
        int resultCount = userMapper.updateByPrimaryKeySelective(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("删除失败");
        }

        return ServerResponse.createBySuccessMessage("删除成功");
    }



}
