package com.business.management.controller;

import com.business.management.annotation.PassToken;
import com.business.management.vo.ProjectVO;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    }



}
