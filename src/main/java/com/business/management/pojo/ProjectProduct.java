package com.business.management.pojo;

import java.util.Date;

public class ProjectProduct {

    private Integer id;

    private Integer projectId;

    private String productName;

    private String productMainMaterial;

    private String productSubMaterial;

    private String productCategory;

    private String productPackage;

    private String productConcept;

    private String productType;

    private String productTargetPrice;

    private String productDetail;

    private String productTargetContent;

    private String productImage;

    private String param1;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    private Date createtime;

    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductMainMaterial() {
        return productMainMaterial;
    }

    public void setProductMainMaterial(String productMainMaterial) {
        this.productMainMaterial = productMainMaterial == null ? null : productMainMaterial.trim();
    }

    public String getProductSubMaterial() {
        return productSubMaterial;
    }

    public void setProductSubMaterial(String productSubMaterial) {
        this.productSubMaterial = productSubMaterial == null ? null : productSubMaterial.trim();
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory == null ? null : productCategory.trim();
    }

    public String getProductPackage() {
        return productPackage;
    }

    public void setProductPackage(String productPackage) {
        this.productPackage = productPackage == null ? null : productPackage.trim();
    }

    public String getProductConcept() {
        return productConcept;
    }

    public void setProductConcept(String productConcept) {
        this.productConcept = productConcept == null ? null : productConcept.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getProductTargetPrice() {
        return productTargetPrice;
    }

    public void setProductTargetPrice(String productTargetPrice) {
        this.productTargetPrice = productTargetPrice == null ? null : productTargetPrice.trim();
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail == null ? null : productDetail.trim();
    }

    public String getProductTargetContent() {
        return productTargetContent;
    }

    public void setProductTargetContent(String productTargetContent) {
        this.productTargetContent = productTargetContent == null ? null : productTargetContent.trim();
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
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