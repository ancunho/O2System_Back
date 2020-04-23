package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectSalesman {

    private Integer id;

    private Integer projectId;

    private Integer salesmanId;

    private String salesmanName;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private String createtime;

    private String updatetime;


}