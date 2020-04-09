package com.business.management.controller;

import com.business.management.annotation.PassToken;
import com.business.management.common.Const;
import com.business.management.common.PropertiesConfig;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.Config;
import com.business.management.pojo.User;
import com.business.management.service.CommonService;
import com.business.management.service.FileService;
import com.business.management.util.DateUtil;
import com.business.management.util.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author : Cunho
 * @date : 2020/3/25
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/common")
public class CommonController {


    @Autowired
    private CommonService commonService;

    @Autowired
    private FileService fileService;

    @Autowired
    private PropertiesConfig propertiesConfig;

    @PassToken
    @RequestMapping(value = "/file/single/upload", method = RequestMethod.POST)
        public ServerResponse file_upload( @RequestParam(value = "singleImageUpload", required = false) MultipartFile file) {
        // 1. 파일 경로 생성
//        System.out.println(">>>>>>>>propertiesConfig file path:" + propertiesConfig.getFilePath());
//        System.out.println("文件原始名称：" + file.getOriginalFilename());
//        System.out.println("文件Name：" + file.getName());
//        System.out.println("文件ContenType：" + file.getContentType());
//        System.out.println("文件大小：" + file.getSize());
//        System.out.println("文件getResource：" + file.getResource());

        if (file.getSize() > 0 && file.getSize() <= (Const.UPLOAD_IMAGE_MAX_SIZE * 1024)) {
            // 2. upload후 완정한 파일경로및 이름 반환
            String targetFileName = fileService.upload(file);
            return ServerResponse.createBySuccess(targetFileName);
        } else {
            return ServerResponse.createByErrorMessage("文件大小不能超过500KB");
        }
    }

    @PassToken
    @RequestMapping(value = "/path")
    public ServerResponse testtest(HttpServletRequest request) {
        System.out.println(">>>>>>>>>>>" + PropertiesUtil.getProperty("cunho.filePath"));
        return ServerResponse.createBySuccess(propertiesConfig.getFilePath());
    }

    /**
     * 코드 입력
     * @param CNF_CODE
     * @return
     */
    @PassToken
    @RequestMapping(value = "/config", method = RequestMethod.POST)
    public ServerResponse config_list(String CNF_CODE) {
        if ("".equals(CNF_CODE) || CNF_CODE == null) {
            return ServerResponse.createByErrorMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        return commonService.configList(CNF_CODE);
    }

    /**
     * 신규코드 추가
     * @param config
     * @return
     */
    @PassToken
    @RequestMapping(value = "/config/insert")
    public ServerResponse config_insert(@RequestBody Config config) {
        return commonService.insert(config);
    }

    /**
     * update config
     * @param config
     * @return
     */
    @PassToken
    @RequestMapping(value = "/config/update")
    public ServerResponse config_update(@RequestBody Config config) {
        return commonService.update(config);
    }


}





