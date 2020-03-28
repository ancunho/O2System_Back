package com.business.management.service;

import com.business.management.pojo.User;

/**
 * @author : Cunho
 * @date : 2020/3/28
 */
public interface TokenService {

    public String getToken(User user);
}
