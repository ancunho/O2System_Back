package com.business.management.controller;

import com.alibaba.fastjson.JSON;
import com.business.management.annotation.PassToken;
import com.business.management.pojo.ProjectBaseinfo;
import com.business.management.pojo.ProjectRecord;
import com.business.management.pojo.User;
import com.business.management.vo.ProjectVO;
import com.google.gson.Gson;
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


    @PassToken
    @RequestMapping(value = "/file")
    public String fileUploadPage(Model model) {
        model.addAttribute("asdf", "asdfasdfsadf");
        return "file_upload";
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(new ProjectVO().toString());
//        ProjectVO projectVO = new ProjectVO();
//        System.out.println(new Gson().toJson(new ProjectVO()));

        ProjectBaseinfo projectBaseinfo = new ProjectBaseinfo();
        projectBaseinfo.setProjectCd("project baseinfo project code");
        projectBaseinfo.setProjectCustomer("customer");
        List<ProjectRecord> projectRecordList = new ArrayList<ProjectRecord>();
        ProjectRecord record1 = new ProjectRecord();
        record1.setRecordId("recode1");
        ProjectRecord record2 = new ProjectRecord();
        record2.setRecordId("recode222");
        projectRecordList.add(record1);
        projectRecordList.add(record2);

        ProjectVO projectVO = new ProjectVO();
        projectVO.setProjectBaseinfo(projectBaseinfo);
        projectVO.setProjectRecordList(projectRecordList);


        System.out.println(JSON.toJSONString(projectVO));




    }



}
