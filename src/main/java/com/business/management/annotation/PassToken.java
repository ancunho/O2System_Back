package com.business.management.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 로그인이 필요없으면 이 어노테이션을 쓴다
 *
 *
 *
 *
 *
 *
 *
 * 
 * @author : Cunho
 * @date : 2020/3/28
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
