package com.business.management.service.impl;

import com.business.management.common.Const;
import com.business.management.common.ServerResponse;
import com.business.management.dao.*;
import com.business.management.pojo.*;
import com.business.management.service.ProjectDetailService;
import com.business.management.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProjectDetailServiceImpl implements ProjectDetailService {

    @Autowired
    private ProjectBaseinfoMapper projectBaseinfoMapper;

    @Autowired
    private ProjectProductMapper projectProductMapper;

    @Autowired
    private ProjectPriceMapper projectPriceMapper;

    @Autowired
    private ProjectRecordMapper projectRecordMapper;

    @Autowired
    private ProjectTimelineMapper projectTimelineMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    @Transactional
    public ServerResponse save(ProjectVO projectVO) {
        /***** 1. 제품정보 Object Save *****/
        int resultCount = projectProductMapper.insert(projectVO.getProjectProduct());
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
        }

        /***** 2. 가격정보 Object Save *****/
        resultCount = projectPriceMapper.insert(projectVO.getProjectPrice());
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
        }

        /***** 3. 이력정보 List Object Save *****/
        for (int i = 0; projectVO.getProjectRecordList() != null && i < projectVO.getProjectRecordList().size(); i++) {
            resultCount = projectRecordMapper.insert(projectVO.getProjectRecordList().get(i));
        }
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
        }

        /***** 4. 타임라인 List Object Save *****/
        for (int i = 0; projectVO.getProjectTimelineList() != null && i < projectVO.getProjectTimelineList().size(); i++) {
            resultCount = projectTimelineMapper.insert(projectVO.getProjectTimelineList().get(i));
        }
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
        }

        return ServerResponse.createBySuccessMessage(Const.Message.SAVE_OK);
    }

    @Override
    @Transactional
    public ProjectVO project_view(Integer projectId) {
        ProjectVO project = new ProjectVO();

        // 1. Baseinfo
        ProjectBaseinfo baseinfo = projectBaseinfoMapper.selectByPrimaryKey(projectId);
        if (baseinfo == null) {
            project.setResponseMsg(Const.Message.SAVE_ERROR);
            return project;
        }
        project.setProjectBaseinfo(baseinfo);

        // 2. Customer
        Customer customer = customerMapper.selectByPrimaryKey(Integer.valueOf(baseinfo.getProjectCustomer()));
        project.setCustomer(customer);

        // 3. Product
        ProjectProduct projectProduct = projectProductMapper.selectByProjectId(projectId);
        project.setProjectProduct(projectProduct);

        // 4. Price
        ProjectPrice projectPrice = projectPriceMapper.selectByProjectId(projectId);
        project.setProjectPrice(projectPrice);

        // 5. Record List
        List<ProjectRecord> projectRecordList = projectRecordMapper.selectByProjectId(projectId);
        project.setProjectRecordList(projectRecordList);

        // 6. Timeline List
        List<ProjectTimeline> timelineList = projectTimelineMapper.selectByProjectId(projectId);
        project.setProjectTimelineList(timelineList);

        return project;
    }

//    public ServerResponse timeline_create(ProjectTimeline projectTimeline) {
//
//    }



}
