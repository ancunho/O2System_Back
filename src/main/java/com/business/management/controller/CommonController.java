package com.business.management.controller;

import com.business.management.annotation.PassToken;
import com.business.management.common.Const;
import com.business.management.common.PropertiesConfig;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.pojo.Config;
import com.business.management.pojo.ProjectFileinfo;
import com.business.management.pojo.User;
import com.business.management.service.CommonService;
import com.business.management.service.FileService;
import com.business.management.service.UserService;
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
    private UserService userService;

    @Autowired
    private PropertiesConfig propertiesConfig;

    @PassToken
    @RequestMapping(value = "/file/single/upload", method = RequestMethod.POST)
    public ServerResponse file_upload(HttpSession session
                                    , @RequestParam(value = "singleImageUpload", required = false) MultipartFile file
                                    , @RequestParam(value = "type") String type
                                    , String projectId) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);

        // 1. 파일 경로 생성
        if (file.getSize() > 0 && file.getSize() <= (Const.UPLOAD_IMAGE_MAX_SIZE * 1024)) {
            //String targetFileName = fileService.upload(file);
            String targetFileName = fileService.saveSingleFile(file);

            if (type.equals(Const.FileType.AVATAR)) {
                currentUser.setImagePhoto(targetFileName);
                ServerResponse response = userService.updateUserAvatarImagePath(currentUser);
                if (response.isSuccess()) {
                    return ServerResponse.createBySuccess(targetFileName);
                } else {
                    return ServerResponse.createByErrorMessage(Const.Message.UPDATE_ERROR);
                }
            } else if(type.equals(Const.FileType.PROJECT_FILE)) {
                ProjectFileinfo fileinfo = new ProjectFileinfo();
                fileinfo.setProjectId(Integer.valueOf(projectId));
                fileinfo.setFileExtension(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1));
                fileinfo.setFilePath(targetFileName);
                fileinfo.setFileName(file.getOriginalFilename());

                ServerResponse response = fileService.saveProjectFile(fileinfo);
                if (response.isSuccess()) {
                    return ServerResponse.createBySuccess(fileinfo);
                } else {
                    return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
                }
            } else {
                return ServerResponse.createBySuccessMessage(Const.Message.SAVE_OK);
            }

        } else {
            return ServerResponse.createByErrorMessage("文件大小不能超过20MB");
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





