package com.business.management.vo;

import com.business.management.pojo.Customer;
import com.business.management.pojo.ProjectCustomer;
import com.business.management.pojo.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : Cunho
 * @date : 2020/4/15
 */
@Data
public class ProjectBaseinfoVO implements Serializable {

    private Integer id;

    private String projectCd;

    private String projectName;

    private String projectPriceTotal;

    private String projectStatus;

    private String projectLocation;

    private String distribution;

    private String projectCreater;

    private String projectStarttime;

    private String projectEndtime;

    private Customer customer;

    private String projectSalesMan;

    private User currentUser;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;
}
