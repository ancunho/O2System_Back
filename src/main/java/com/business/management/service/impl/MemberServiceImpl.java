package com.business.management.service.impl;

import com.business.management.common.Const;
import com.business.management.common.ServerResponse;
import com.business.management.dao.UserMapper;
import com.business.management.pojo.User;
import com.business.management.service.MemberService;
import com.business.management.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Cunho
 * @date : 2020/3/25
 */
@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse getUserList() {
        // 1. startPage -- start
//        PageHelper.startPage(pageNum, pageSize);
        // 2. 填充自己的sql逻辑
        List<User> userList = userMapper.selectAllUser();
        // 3. PageHelper收尾
//        PageInfo pageResult = new PageInfo(userList);
//        pageResult.setList(userList);

        return ServerResponse.createBySuccess(userList);
    }

    @Override
    public ServerResponse getUserListOnlyIDAndRealname() {
        List<User> userList = userMapper.getUserListOnlyIDAndRealname();
        return ServerResponse.createBySuccess(userList);
    }

    @Override
    public ServerResponse<User> getUserById(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return ServerResponse.createByErrorMessage("未存在用户");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);
    }

    @Override
    public ServerResponse<User> updateUserById(User updateUser) {
        int updateCount = userMapper.updateByPrimaryKeySelective(updateUser);
        if (updateCount > 0) {
            return ServerResponse.createBySuccess("更新成功", updateUser);
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public ServerResponse updateUserStatus(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户查询失败");
        }

        if (Const.Status.ACTIVE.equals(user.getStatus())) {
            user.setStatus(Const.Status.NOT_ACTIVE);
        } else if (Const.Status.NOT_ACTIVE.equals(user.getStatus())){
            user.setStatus(Const.Status.ACTIVE);
        }

        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public ServerResponse<String> delete_member(User user) {
        int resultCount = userMapper.updateByPrimaryKeySelective(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("删除失败");
        }

        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse resetPassword(Integer userId) {
        User updateUser = userMapper.selectByPrimaryKey(userId);
        if (updateUser == null) {
            return ServerResponse.createByErrorMessage("用户查询失败");
        }
        // 密码改为MD5格式
        updateUser.setPassword(MD5Util.MD5EncodeUtf8(Const.DEFAULT_PASSWORD));
        int updateCount = userMapper.updatePasswordByUsername(updateUser.getUsername(), updateUser.getPassword());
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("密码初始化成功");
        }

        return ServerResponse.createByErrorMessage("密码初始化失败");
    }


}
