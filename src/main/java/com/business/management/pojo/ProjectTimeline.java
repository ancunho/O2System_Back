package com.business.management.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectTimeline {

    private Integer id;

    private Integer projectId;

    private String timelineId;

    private String timelineContent;

    private String timelineAuthor;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;


}