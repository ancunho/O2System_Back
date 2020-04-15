package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectCustomer {

    private Integer id;

    private String projectId;  //from front

    private String customerName;  //from front

    private String customerNameKr;

    private String customerCd;  //from front

    private String director;  //from front

    private String status;  //from front

    private String phone;  //from front

    private String wechat;  //from front

    private String description;

    private String salesVolumn;

    private String developmentSkill;

    private String target;

    private String productList;

    private String distribution;

    private String province;

    private String city;

    private String area;

    private String address;

    private String salesMan;

    private String customerImage;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;


}