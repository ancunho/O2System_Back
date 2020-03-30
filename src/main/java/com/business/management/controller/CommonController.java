package com.business.management.controller;

import com.business.management.annotation.PassToken;
import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.User;
import com.business.management.service.CommonService;
import com.business.management.service.FileService;
import com.business.management.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @PassToken
    @RequestMapping(value = "/file/single/upload", method = RequestMethod.POST)
    public ServerResponse file_upload(HttpSession session
            , @RequestParam(value = "singleImageUpload", required = false) MultipartFile file
            , HttpServletRequest request) {
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (user == null) {
//            return ServerResponse.createByErrorMessage(ResponseCode.NEED_LOGIN.getDesc());
//        }

        // 1. 파일 경로 생성
        String path = request.getServletContext().getRealPath(DateUtil.getDays());
        log.info("文件的上传路径是：{}", path);

        if (file.getSize() > 0 && file.getSize() <= (Const.UPLOAD_IMAGE_MAX_SIZE * 1024)) {
            // 2. upload후 완정한 파일경로및 이름 반환
            String targetFileName = fileService.upload(file, path);
            return ServerResponse.createBySuccess(targetFileName);
        } else {
            return ServerResponse.createByErrorMessage("文件大小不能超过500KB");
        }
    }

    @PassToken
    @RequestMapping(value = "/config", method = RequestMethod.POST)
    public ServerResponse config_list(String CNF_CODE) {
        if ("".equals(CNF_CODE) || CNF_CODE == null) {
            return ServerResponse.createByErrorMessage(ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        return commonService.configList(CNF_CODE);

    }

}





