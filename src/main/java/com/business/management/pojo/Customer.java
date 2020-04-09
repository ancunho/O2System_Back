package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {

    private Integer id;

    private String customerName;

    private String customerNameKr;

    private String customerCd;

    private String director;

    private String status;

    private String phone;

    private String wechat;

    private String description;

    private String target;

    private String productList;

    private String distribution;

    private String province;

    private String city;

    private String area;

    private String address;

    private String author;

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