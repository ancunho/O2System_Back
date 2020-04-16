package com.business.management.vo;

import com.business.management.pojo.Customer;
import com.business.management.pojo.ProjectTimeline;
import com.business.management.pojo.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectListVO implements Serializable {

    private Integer id;

    private String projectCd;

    private String projectName;

    private Customer customer;

    private String projectStatus;

    private String projectStarttime;

    private String projectEndtime;

    private ProjectTimeline projectTimeline;

    private User currentUser;

}
