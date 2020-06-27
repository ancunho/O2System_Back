package com.business.management.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectListVO implements Serializable {

    private Integer id;

    private String projectCd;

    private String projectName;

    private String projectCustomer;

    private String customerName;

    private String productName;

    private String projectStatus;

    private String projectSalesMan;

    private String projectPriceTotal;

    private String projectStarttime;

    private String projectEndtime;

    private String createtime;

    private String updatetime;

}
