package com.business.management.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.business.management.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Cunho
 * @date : 2020/3/28
 */
@Slf4j
public class TokenUtil {

    public static final String TOKEN_HEADER = "Access-Token";
    public static final String TOKEN_PREFIX = "Bearer ";

    //过期时间，设置一个小时
    private static final long TOKEN_EXPIRE_TIME = 60 * 60 * 1000;
    // 密钥
    private static final String TOKEN_SECRET = "ancunhotoken";

    /**
     * 生成Token
     *
     * @param user
     * @return
     */
    public static String createToken(User user) {
        // 1. 设置Token过期时间
        Date date = new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME);

        // 2. 使用HS256算法把密钥+密码加密
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

        log.info("正在创建Token的用户>>>>>>>>>>" + user.toString());

        Map<String , Object> tokenHeaderParam = new HashMap<>();
        tokenHeaderParam.put("alg", "HS256");
        tokenHeaderParam.put("typ", "JWT");

        // 3. 生成Token
        String token = JWT.create() //创建Token实例
                .withHeader(tokenHeaderParam)
                .withClaim("USERNAME", user.getUsername())
                .withClaim("ROLE", user.getRole())
                .withAudience(user.getId().toString())
                .withExpiresAt(date) //过期时间
                .sign(algorithm); //签名

        log.info(" 用户[" + user.getId() + "] 创建Token>>>>>>>>>>" + token);
        return token;
    }


    public static boolean verify(String token) {
        try {
            String username = getUsernameByToken(token);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("USERNAME", username)
                    .build();

            DecodedJWT jwt = verifier.verify(token);

//            log.info(jwt.getHeader(),jwt.getPayload(), jwt.getSignature());
//            log.info(jwt.getToken());
            return true;
        } catch (Exception e) {
            log.info("校验token错误");
            return false;
        }
    }

    /**
     * 通过token获取username
     * @param token
     * @return
     */
    public static String getUsernameByToken(String token) {
        try {
            return JWT.decode(token).getClaim("USERNAME").asString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 通过token获取userid
     * @param token
     * @return
     */
    public static Integer getUserIdByToken(String token) {
        try {
            return Integer.parseInt(JWT.decode(token).getAudience().get(0));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 通过token获取user的权限名
     * @param token
     * @return
     */
    public static String getUserRoleByToken(String token) {
        try {
            return JWT.decode(token).getClaim("ROLE").asString();
        } catch (Exception e) {
            return null;
        }
    }

}
