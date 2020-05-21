package com.business.management.service.impl;

import com.business.management.common.PropertiesConfig;
import com.business.management.service.FileService;
import com.business.management.util.DateUtil;
import com.business.management.util.FTPUtil;
import com.business.management.util.ValueUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author : Cunho
 * @date : 2020/3/29
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Override
    public String upload(MultipartFile file) {
        //文件名
        String fileName = file.getOriginalFilename();
        //文件扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        //文件新名字  UUID.randomUUID().toString()
        String uploadFileName = DateUtil.getTime() + "_" + ValueUtil.generateUid(10) + "." + fileExtensionName;
        //文件路径 + "/"
        String remotePath = File.separator +  DateUtil.getDays() + File.separator;
        //文件保存路径
        String path = propertiesConfig.getFilePath() + remotePath;

        log.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }

        File targetFile = new File(path, uploadFileName);

        try {
//            file.transferTo(targetFile);
            //上传到FTP
            FTPUtil.uploadFile(remotePath, Lists.newArrayList(targetFile));
            //上传到FTP后删除原来的图片
//            targetFile.delete();
        } catch (Exception e) {
            log.error("上传文件异常：",e);
            return null;
        }
        String finalFileName = propertiesConfig.getFileServerHttpPrefix() + remotePath + targetFile.getName();

        return finalFileName;
    }


}
