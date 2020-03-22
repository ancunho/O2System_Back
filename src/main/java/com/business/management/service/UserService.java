package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;

/**
 * @author : Cunho
 * @date : 2020/3/22
 */
public interface UserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse checkAdminRole(User user);
    ServerResponse<String> addUser(User user);

    public ServerResponse<String> checkValid(String str, String type);


}
