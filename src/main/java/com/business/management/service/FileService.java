package com.business.management.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Cunho
 * @date : 2020/3/29
 */
public interface FileService {

    String upload(MultipartFile file);

    String saveSingleFile(MultipartFile file);

}
