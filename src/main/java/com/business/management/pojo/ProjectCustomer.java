package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectCustomer {

    private Integer id;

    private Integer projectId;

    private String customerName;

    private String customerCd;

    private String director;

    private String status;

    private String phone;

    private String wechat;

    private String description;

    private String salesVolumn;

    private String developmentSkill;

    private String target;

    private String productList;

    private String distribution;

    private String city;

    private String address;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;


}