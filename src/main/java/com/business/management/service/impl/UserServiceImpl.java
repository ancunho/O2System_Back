package com.business.management.service.impl;

import com.business.management.common.Const;
import com.business.management.common.ServerResponse;
import com.business.management.dao.UserMapper;
import com.business.management.pojo.User;
import com.business.management.service.UserService;
import com.business.management.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, md5Password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }

        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);
    }

    @Override
    public ServerResponse checkAdminRole(User user) {
        if (user != null && user.getRole() == Const.Role.ROLE_ADMIN) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
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
        // 3. 기본 권한을 일반사용자로 한다. 값 => 0
        user.setRole(Const.Role.ROLE_CUSTOMER);
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
                }
            }
            //邮箱校验
            if (Const.EMAIL.equals(type)) {
                int resultCount = userMapper.checkEmail(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("Email已存在，请使用其他Email");
                }
            }
        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }
}
