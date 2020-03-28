package com.business.management.util;

import com.auth0.jwt.JWT;
import com.business.management.pojo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Cunho
 * @date : 2020/3/28
 */
public class TokenUtil {

    public static String getTokenUserId() {
        String token = getRequest().getHeader("Access-Token");
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;
    }

//    public User getCurrentUser() {
//
//    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

}
