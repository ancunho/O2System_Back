package com.business.management.vo;

import com.business.management.pojo.ProjectCustomer;
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

    private String projectStarttime;

    private String projectEndtime;

    private ProjectCustomer projectCustomer;

    private String projectSalesMan;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;
}
