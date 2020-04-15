package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectProduct {
    private Integer id;

    private Integer projectId;

    private String productName;

    private String productMainMaterial;

    private String productSubMaterial;

    private String productCategory;

    private String productPackage;

    private String productConcept;

    private String productType;

    private String productQuantity;

    private String productTargetPrice;

    private String productDetail;

    private String productTargetContent;

    private String productImage;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;


}