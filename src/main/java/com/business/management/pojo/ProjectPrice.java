package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectPrice {

    private Integer id;

    private Integer projectId;

    private Integer projectProductId;

    private String productName;

    private String orderQuantity;

    private String actualInput;

    private String unitWeight;

    private String weight;

    private String packageSpec;

    private String theoryQuantity;

    private String yieldPercent;

    private String actualProduction;

    private String priceList;

    private String descriptionList;

    private String remark;

    private String valueNoVat;

    private String specialComment;

    private String personInCharge;

    private String releaseDate;

    private String dealPlace;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;


}