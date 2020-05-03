package com.business.management.controller;

import com.alibaba.fastjson.JSON;
import com.business.management.annotation.PassToken;
import com.business.management.common.Const;
import com.business.management.dao.ProjectBaseinfoMapper;
import com.business.management.pojo.*;
import com.business.management.vo.ProjectBaseinfoVO;
import com.business.management.vo.ProjectListVO;
import com.business.management.vo.ProjectVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Cunho
 * @date : 2020/3/29
 */
@Controller
@RequestMapping("/page")
public class HelloController {

    @Autowired
    private ProjectBaseinfoMapper projectBaseinfoMapper;

    @PassToken
    @RequestMapping(value = "/file")
    public String fileUploadPage(Model model) {
        model.addAttribute("asdf", "asdfasdfsadf");
        return "file_upload";
    }
//
//    public static void main(String[] args) throws Exception {
////        List<ProjectListVO> projectList = this.projectBaseinfoMapper.getProjetList();
//
////        System.out.println(projectList.size());
//
//        if ("R" == "R") {
//            System.out.println("OK");
//        } else {
//            System.out.println("NO");
//        }
//
//    }

    /*
    public ProjectBaseinfoVO baseinfoObj() {

        ProjectBaseinfoVO baseinfo = new ProjectBaseinfoVO();
        baseinfo.setProjectCd("2020041800002");
        baseinfo.setProjectName("project name2222");
        baseinfo.setProjectSalesMan("[3,12,24]");
        baseinfo.setProjectPriceTotal("90000元");
        baseinfo.setProjectStatus(Const.ProjectStatus.KICKOFF);
        baseinfo.setProjectStarttime("2020-03-01");
        baseinfo.setProjectEndtime("2022-09-01");

        User currentUser = new User();
        currentUser.setRealname("安春浩");

        Customer customer = new Customer();
        customer.setProjectId("[2,23]");
        customer.setCustomerName("customer name2222");
        customer.setCustomerNameKr("customer kr name2222");
        customer.setCustomerCd("customer002");
        customer.setAuthor("cunho");
        customer.setDirector("direcotr");
        customer.setStatus(Const.Status.ACTIVE);
        customer.setPhone("18521095572");
        customer.setWechat("cunho910");
        customer.setDescription("text text texttext text texttext text texttext text text");
        customer.setSalesVolumn("1,000,000");
        customer.setDevelopmentSkill("developementskill");
        customer.setTarget("target");
        customer.setProductList("['牛奶','水果','冰淇淋','可乐']");
        customer.setDistribution("distribution");
        customer.setProvince("辽宁省");
        customer.setCity("大连市");
        customer.setArea("开发区");
        customer.setAddress("阿斯顿看风使舵 XXXX号");
        customer.setSalesMan("[2,4,9]");
        customer.setCustomerImage("http://114.55.169.130:8000/images/xxxxx.jpg");
        baseinfo.setCustomer(customer);

        baseinfo.setCurrentUser(currentUser);

        System.out.println(JSON.toJSONString(baseinfo));

    }

     */

//    public ProjectVO projectVO() {
//        ProjectVO projectVO = new ProjectVO();
//
//        ProjectProduct product = new ProjectProduct();
//        product.setProjectId(1);
//        product.setProductName("제품명");
//        product.setProductMainMaterial("['text1','222','333','444']");
//        product.setProductSubMaterial("['aaa','bbb','cccc','dddd']");
//        product.setProductCategory("2");
//        product.setProductPackage("4");
//        product.setProductConcept("text text text");
//        product.setProductType("33");
//        product.setProductQuantity("234");
//        product.setProductTargetPrice("3999");
//        product.setProductDetail("text text text text");
//        product.setProductTargetContent("text text text");
//        product.setProductImage("http://114.xxxxxxxx/xxxx.jpg");
//        projectVO.setProjectProduct(product);
//
//        ProjectPrice price = new ProjectPrice();
//        price.setProjectId(1);
//        price.setProjectProductId(2);
//        price.setProductName("제품명");
//        price.setOrderQuantity("111");
//        price.setActualInput("11111");
//        price.setUnitWeight("99");
//        price.setWeight("999");
//        price.setPackageSpec("22222");
//        price.setTheoryQuantity("88888");
//        price.setYieldPercent("8");
//        price.setActualProduction("9999");
//        price.setPriceList("json");
//        price.setDescriptionList("json");
//        price.setRemark("text text text");
//        price.setValueNoVat("text");
//        price.setSpecialComment("text");
//        price.setPersonInCharge("text");
//        price.setReleaseDate("2020-04-20");
//        price.setDealPlace("text");
//        projectVO.setProjectPrice(price);
//
//        List<ProjectRecord> recordList = new ArrayList<ProjectRecord>();
//        ProjectRecord record1 = new ProjectRecord();
//        record1.setProjectId(1);
//        record1.setRecordId("1");
//        record1.setRecordContent("json json json json json");
//        recordList.add(record1);
//
//        ProjectRecord record2 = new ProjectRecord();
//        record2.setProjectId(1);
//        record2.setRecordId("2");
//        record2.setRecordContent("json json json json json");
//        recordList.add(record2);
//
//        ProjectRecord record3 = new ProjectRecord();
//        record3.setProjectId(1);
//        record3.setRecordId("3");
//        record3.setRecordContent("json2 json json json json");
//        recordList.add(record3);
//
//        ProjectRecord record4 = new ProjectRecord();
//        record4.setProjectId(1);
//        record4.setRecordId("4");
//        record4.setRecordContent("json4 json json json json");
//        recordList.add(record4);
//
//        ProjectRecord record5 = new ProjectRecord();
//        record5.setProjectId(1);
//        record5.setRecordId("5");
//        record5.setRecordContent("json5 json json json json");
//        recordList.add(record5);
//
//        projectVO.setProjectRecordList(recordList);
//
//        List<ProjectTimeline> timelineList = new ArrayList<>();
//        ProjectTimeline timeline1 = new ProjectTimeline();
//        timeline1.setProjectId(1);
//        timeline1.setTimelineId("1");
//        timeline1.setTimelineContent("json");
//        timeline1.setTimelineAuthor("XXXXX");
//        timelineList.add(timeline1);
//
//        ProjectTimeline timeline2 = new ProjectTimeline();
//        timeline2.setProjectId(1);
//        timeline2.setTimelineId("2");
//        timeline2.setTimelineContent("json");
//        timeline2.setTimelineAuthor("XXXXX");
//        timelineList.add(timeline2);
//
//        ProjectTimeline timeline3 = new ProjectTimeline();
//        timeline3.setProjectId(1);
//        timeline3.setTimelineId("3");
//        timeline3.setTimelineContent("json");
//        timeline3.setTimelineAuthor("XXXXX");
//        timelineList.add(timeline3);
//
//        projectVO.setProjectTimelineList(timelineList);
//
//        System.out.println(JSON.toJSONString(projectVO));
//
//        return projectVO;
//    }




}
