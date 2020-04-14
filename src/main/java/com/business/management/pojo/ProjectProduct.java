package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectProduct {

    private Integer id;

    private Integer projectId;

    private String productName;

    private String productMainMaterial; // 핵심원료

    private String productSubMaterial; //부원료

    private String productCategory; //카테고리

    private String productPackage; //포장유형

    private String productConcept; //제품컨셉

    private String productType; //식품유형

    private String productTargetPrice; //타겟가격

    private String productDetail; //상세비고

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