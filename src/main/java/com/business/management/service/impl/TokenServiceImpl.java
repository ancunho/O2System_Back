package com.business.management.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.business.management.pojo.User;
import com.business.management.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : Cunho
 * @date : 2020/3/28
 */
@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public String getToken(User user) {
        Date startTime = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000; //一小时有效时间
        Date endTime = new Date(currentTime);
        String token = "";
        token = JWT.create().withAudience(user.getId().toString()).withIssuedAt(startTime).withExpiresAt(endTime).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }



}
