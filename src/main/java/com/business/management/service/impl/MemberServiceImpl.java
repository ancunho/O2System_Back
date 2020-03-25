package com.business.management.service.impl;

import com.business.management.common.ServerResponse;
import com.business.management.dao.UserMapper;
import com.business.management.pojo.User;
import com.business.management.service.MemberService;
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
    public ServerResponse getUserList(int pageNum, int pageSize) {
        // 1. startPage -- start
        PageHelper.startPage(pageNum, pageSize);
        // 2. 填充自己的sql逻辑
        List<User> userList = userMapper.selectAllUser();
        // 3. PageHelper收尾
        PageInfo pageResult = new PageInfo(userList);
        pageResult.setList(userList);

        return ServerResponse.createBySuccess(pageResult);
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


}
