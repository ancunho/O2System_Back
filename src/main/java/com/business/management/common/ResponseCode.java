package com.business.management.common;


/**
 * @author : Cunho
 * @date : 2020/3/22
 */
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),                       // 성공
    ERROR(1,"ERROR"),                           // 실패
    NEED_LOGIN(10,"You need login"),            // 로그인필요
    NO_PERMISSION(99,"NO PERMISSION"),          // 권한없음
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");     // 파라미터 에러

    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }

}
