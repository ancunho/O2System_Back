package com.business.management.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.business.management.annotation.PassToken;
import com.business.management.annotation.UserLoginToken;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.pojo.User;
import com.business.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author : Cunho
 * @date : 2020/3/28
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 2. 检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }


        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                String tokenHeaer = request.getHeader(TokenUtil.TOKEN_HEADER);
                if (tokenHeaer == null) {
                    throw new RuntimeException("无token");
                }

                String token = tokenHeaer.replace(TokenUtil.TOKEN_PREFIX, "");
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }

                boolean b = TokenUtil.verify(token);
                if (b == false) {
                    throw new RuntimeException("token不存在或已失效，请重新获取token");
                }

                return true;

                // 获取 token 中的 user id
//                String userId;
//                try {
//                    userId = JWT.decode(token).getAudience().get(0);
//                    for (int i = 0; i < JWT.decode(token).getAudience().size(); i++) {
//                        System.out.println(JWT.decode(token).getClaim("ROLE").asString());
//                        System.out.println(">>>>>token[" + i + "]:>>> " + JWT.decode(token).getAudience().get(i));
//                    }
//                } catch (JWTDecodeException j) {
//                    throw new RuntimeException("401");
//                }
//                Integer id = Integer.parseInt(userId);
//                User user = userService.findUserById(id);
//                if (user == null) {
//                    throw new RuntimeException("用户不存在，请重新登录");
//                }
//                // 验证 token
//                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
//                try {
//                    jwtVerifier.verify(token);
//                } catch (JWTVerificationException e) {
//                    throw new RuntimeException("401");
//                }
//                //将验证通过后的用户信息放到请求中
//                request.setAttribute(Const.CURRENT_USER, user);
            }
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
