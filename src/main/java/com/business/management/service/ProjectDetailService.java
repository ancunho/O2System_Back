package com.business.management.service;

import com.business.management.common.ServerResponse;
import com.business.management.pojo.ProjectTimeline;
import com.business.management.vo.ProjectVO;

public interface ProjectDetailService {

    /**
     * 제품정보 + 가격정보 + 이력정보 + 파일 정보
     * @param projectVO
     * @return
     */
    ServerResponse save(ProjectVO projectVO);

    /**
     * detail update
     * @param projectVO
     * @return
     */
    ServerResponse update(ProjectVO projectVO);

    /**
     * view
     * @param projectId
     * @return
     */
    ProjectVO project_view(String projectId);

    /**
     * timeline list
     * @param projectId
     * @return
     */
    ServerResponse timeline_list(Integer projectId);

    /**
     * timeline update
     * @param projectTimeline
     * @return
     */
    ServerResponse timeline_update(ProjectTimeline projectTimeline);

    /**
     * timeline create
     * @param projectTimeline
     * @return
     */
    ServerResponse timeline_create(ProjectTimeline projectTimeline);

    /**
     * Get project record list by project id
     * @param projectId
     * @return
     */
    ServerResponse getRecordByProjectId(Integer projectId);

}
