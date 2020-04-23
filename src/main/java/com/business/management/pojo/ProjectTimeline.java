package com.business.management.pojo;

import lombok.Data;


@Data
public class ProjectTimeline {
    private Integer id;

    private Integer projectId;

    private String meetingTime;

    private String meetingDate;

    private String timelineContent;

    private String timelineAuthor;

    private String status;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private String createtime;

    private String updatetime;


}