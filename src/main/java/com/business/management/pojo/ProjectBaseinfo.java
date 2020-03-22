package com.business.management.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProjectBaseinfo implements Serializable {

    private Integer projectId;

    private String projectCd;

    private String projectName;

    private String projectCustomer;

    private String projectPriceTotal;

    private String projectStatus;

    private String projectStarttime;

    private String projectEndtime;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectCd() {
        return projectCd;
    }

    public void setProjectCd(String projectCd) {
        this.projectCd = projectCd == null ? null : projectCd.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectCustomer() {
        return projectCustomer;
    }

    public void setProjectCustomer(String projectCustomer) {
        this.projectCustomer = projectCustomer == null ? null : projectCustomer.trim();
    }

    public String getProjectPriceTotal() {
        return projectPriceTotal;
    }

    public void setProjectPriceTotal(String projectPriceTotal) {
        this.projectPriceTotal = projectPriceTotal == null ? null : projectPriceTotal.trim();
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus == null ? null : projectStatus.trim();
    }

    public String getProjectStarttime() {
        return projectStarttime;
    }

    public void setProjectStarttime(String projectStarttime) {
        this.projectStarttime = projectStarttime == null ? null : projectStarttime.trim();
    }

    public String getProjectEndtime() {
        return projectEndtime;
    }

    public void setProjectEndtime(String projectEndtime) {
        this.projectEndtime = projectEndtime == null ? null : projectEndtime.trim();
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1 == null ? null : param1.trim();
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2 == null ? null : param2.trim();
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3 == null ? null : param3.trim();
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4 == null ? null : param4.trim();
    }

    public String getParam5() {
        return param5;
    }

    public void setParam5(String param5) {
        this.param5 = param5 == null ? null : param5.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}