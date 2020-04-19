package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectRecord {

    private Integer id;

    private Integer projectId;

    private String recordId;

    private String recordContent;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private String createtime;

    private String updatetime;


}