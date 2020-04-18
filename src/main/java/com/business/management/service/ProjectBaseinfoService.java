package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.pojo.ProjectBaseinfo;
import com.business.management.vo.ProjectBaseinfoVO;
import com.business.management.vo.ProjectListVO;

import java.util.List;

/**
 * @author : Cunho
 * @date : 2020/4/15
 */
public interface ProjectBaseinfoService {

    /**
     * PJ 기본정보 저장
     * @param projectBaseinfoVO
     * @return
     */
    ServerResponse save(ProjectBaseinfoVO projectBaseinfoVO);

    /**
     * PJ 기본정보 수정
     * @param projectBaseinfo
     * @return
     */
    ServerResponse update(ProjectBaseinfo projectBaseinfo);

    /**
     * PJ 리스트 반환
     * @return
     */
    List<ProjectListVO> getProjectlist();




}
