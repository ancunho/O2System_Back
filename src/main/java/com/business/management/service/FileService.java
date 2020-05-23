package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.pojo.ProjectFileinfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Cunho
 * @date : 2020/3/29
 */
public interface FileService {

    String upload(MultipartFile file);

    String saveSingleFile(MultipartFile file);

    ServerResponse saveProjectFile(ProjectFileinfo fileinfo);

}
