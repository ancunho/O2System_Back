package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author : Cunho
 * @date : 2020/3/31
 */
@Data
public class Log {

    private Integer id;

    private String author;

    private String actionId;

    private String actionName;

    private Integer projectId;

    private Integer productId;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;





}
