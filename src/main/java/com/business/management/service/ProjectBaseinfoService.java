package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.vo.ProjectBaseinfoVO;

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




}
