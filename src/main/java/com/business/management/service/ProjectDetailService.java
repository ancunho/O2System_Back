package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.vo.ProjectVO;

public interface ProjectDetailService {

    /**
     * 제품정보 + 가격정보 + 이력정보 + 파일 정보
     * @param projectVO
     * @return
     */
    ServerResponse save(ProjectVO projectVO);

}
