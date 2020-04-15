package com.business.management.service.impl;

import com.business.management.common.Const;
import com.business.management.common.ServerResponse;
import com.business.management.dao.ProjectBaseinfoMapper;
import com.business.management.pojo.ProjectBaseinfo;
import com.business.management.service.ProjectBaseinfoService;
import com.business.management.vo.ProjectBaseinfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : Cunho
 * @date : 2020/4/15
 */
@Slf4j
@Service
public class ProjectBaseinfoServiceImpl implements ProjectBaseinfoService {

    @Autowired
    private ProjectBaseinfoMapper projectBaseinfoMapper;

    /**
     * step1 = {
       projectCd: '123',  projectName: '项目名', projectPriceTotal: '9999', projectStatus: '0', projectStarttime: '2020-05-01', projectEndtime: '2020-06-01',
       projectCustomer: {
         // id null 추가 아님 갱신
         id: 1,
         // 필수
         customerName: '123', province: '123',  city: '123', area: '123', address: '123', director: '123',  salesVolumn: '123',  developmentSkill: '123',
         // 더보기
     phone: '123', wechat: '123', description: '123', target: '123', productList: '123',
     distribution: '123', salesMan: "[1,2,3]", // projectSalesMan 같음  customerImage: '123', // list쪽 status: '123', // 관리자쪽
       },
       projectSalesMan: "[1,2,3]"
     }
     * @param projectBaseinfoVO
     * @return
     */
    @Override
    public ServerResponse save(ProjectBaseinfoVO projectBaseinfoVO) {
        /*** 1. ProjectBaseinfo Object Save ****/
        ProjectBaseinfo projectBaseinfo = new ProjectBaseinfo();
        // -- 프로젝트 코드
        projectBaseinfo.setProjectCd(projectBaseinfoVO.getProjectCd());
        // -- 프로젝트명
        projectBaseinfo.setProjectName(projectBaseinfoVO.getProjectName());
        // -- 프로젝트 고객명
        projectBaseinfo.setProjectCustomer(projectBaseinfoVO.getProjectCustomer().getCustomerName());
        // -- 프로젝트 영업담당자
        projectBaseinfo.setProjectSalesMan(projectBaseinfoVO.getProjectSalesMan());
        // -- 프로젝트 예상총매출
        projectBaseinfo.setProjectPriceTotal(projectBaseinfoVO.getProjectPriceTotal());
        // -- 프로젝트 상태
        projectBaseinfo.setProjectStatus(Const.ProjectStatus.KICKOFF);
        // -- 프로젝트 시작일
        projectBaseinfo.setProjectStarttime(projectBaseinfoVO.getProjectStarttime());
        // -- 프로젝트 예상마감일
        projectBaseinfo.setProjectEndtime(projectBaseinfoVO.getProjectEndtime());
        // 저장
        int resultCount = projectBaseinfoMapper.insert(projectBaseinfo);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("新增失败");
        }

        return ServerResponse.createBySuccessMessage("新增成功");
    }



}
