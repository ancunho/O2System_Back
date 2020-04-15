package com.business.management.common;

/**
 * @author : Cunho
 * @date : 2020/3/22
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public static final String RedirectLoginPage = "login";

    public static final String DEFAULT_PASSWORD = "123456";

    /**
     * 上传图片的最大大小： 500K
     * 1KB = 1024Byte
     */
    public static final Integer UPLOAD_IMAGE_MAX_SIZE = 500;

    public interface RoleNo{
        String ROLE_USER        = "0";     //普通用户
        String ROLE_ADMIN       = "1";        //管理员
        String ROLE_EDITOR      = "2";      //组长？
    }


    public interface Role{
        String ROLE_USER        = "ROLE_USER";     //普通用户
        String ROLE_ADMIN       = "ROLE_ADMIN";        //管理员
        String ROLE_EDITOR      = "ROLE_EDITOR";      //组长？
    }

    public interface Status {
        String ACTIVE       = "1"; //已激活
        String NOT_ACTIVE   = "0"; //未激活
    }

    public interface Cart{
        int CHECKED         = 1;//即购物车选中状态
        int UN_CHECKED      = 0;//购物车中未选中状态

        String LIMIT_NUM_FAIL       = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS    = "LIMIT_NUM_SUCCESS";
    }

    public interface Sex {
        String male     = "1"; // 男
        String female   = "2"; // 女
    }

    public interface ProjectStatus {
        String KICKOFF              = "1";
        String AGREEMENT            = "2";
        String EXPORT_PREPARATION   = "3";
        String CONTRACT_ORDER       = "4";
        String PRODUCTION_EXPORT    = "5";
        String EXPORT_AS            = "6";
        String REJECT               = "99";
    }

}
