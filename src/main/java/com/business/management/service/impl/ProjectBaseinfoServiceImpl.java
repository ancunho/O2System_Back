package com.business.management.service.impl;

import com.business.management.common.Const;
import com.business.management.common.ServerResponse;
import com.business.management.dao.CustomerMapper;
import com.business.management.dao.ProjectBaseinfoMapper;
import com.business.management.pojo.Customer;
import com.business.management.pojo.ProjectBaseinfo;
import com.business.management.pojo.ProjectCustomer;
import com.business.management.service.ProjectBaseinfoService;
import com.business.management.vo.ProjectBaseinfoVO;
import com.business.management.vo.ProjectListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Cunho
 * @date : 2020/4/15
 */
@Slf4j
@Service
public class ProjectBaseinfoServiceImpl implements ProjectBaseinfoService {

    @Autowired
    private ProjectBaseinfoMapper projectBaseinfoMapper;

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 프로젝트 기본정보 저장
     * 기본정보 + 고객정보 + 영업담당
     * @param projectBaseinfoVO
     * @return
     */
    @Override
    @Transactional
    public ServerResponse save(ProjectBaseinfoVO projectBaseinfoVO) {
        int resultCount = 0;
        /***** 2. ProjectCustomer Object Save *****/
        if (projectBaseinfoVO.getCustomer().getId() == null || "".equals(projectBaseinfoVO.getCustomer().getId())) {
            // 如果没有id，则新增
            Customer customer = new Customer();
//            customer.setId(projectBaseinfoVO.getCustomer().getId());
//            customer.setProjectId(projectBaseinfoVO.getCustomer().getProjectId());
            customer.setCustomerName(projectBaseinfoVO.getCustomer().getCustomerName());
            customer.setCustomerNameKr(projectBaseinfoVO.getCustomer().getCustomerNameKr());
            customer.setCustomerCd(projectBaseinfoVO.getCustomer().getCustomerCd());
            customer.setAuthor(projectBaseinfoVO.getCurrentUser().getRealname());
            customer.setDirector(projectBaseinfoVO.getCustomer().getDirector());
            customer.setStatus(Const.Status.ACTIVE);
            customer.setCustomerType(projectBaseinfoVO.getCustomer().getCustomerType());
            customer.setPhone(projectBaseinfoVO.getCustomer().getPhone());
            customer.setWechat(projectBaseinfoVO.getCustomer().getWechat());
            customer.setDescription(projectBaseinfoVO.getCustomer().getDescription());
            customer.setSalesVolumn(projectBaseinfoVO.getCustomer().getSalesVolumn());
            customer.setDevelopmentSkill(projectBaseinfoVO.getCustomer().getDevelopmentSkill());
            customer.setTarget(projectBaseinfoVO.getCustomer().getTarget());
            customer.setProductList(projectBaseinfoVO.getCustomer().getProductList());
            customer.setDistribution(projectBaseinfoVO.getCustomer().getDistribution());
            customer.setProvince(projectBaseinfoVO.getCustomer().getProvince());
            customer.setCity(projectBaseinfoVO.getCustomer().getCity());
            customer.setArea(projectBaseinfoVO.getCustomer().getArea());
            customer.setAddress(projectBaseinfoVO.getCustomer().getAddress());
            customer.setSalesMan(projectBaseinfoVO.getCustomer().getSalesMan());
            customer.setCustomerImage(projectBaseinfoVO.getCustomer().getCustomerImage());
            customer.setParam1(projectBaseinfoVO.getCustomer().getParam1());
            customer.setParam2(projectBaseinfoVO.getCustomer().getParam2());
            customer.setParam3(projectBaseinfoVO.getCustomer().getParam3());
            customer.setParam4(projectBaseinfoVO.getCustomer().getParam4());
            customer.setParam5(projectBaseinfoVO.getCustomer().getParam5());

            resultCount = customerMapper.insertWhenCreateNewProject(customer);
            projectBaseinfoVO.getCustomer().setId(customer.getId());

            if (resultCount == 0) {
                return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
            }

        } else {
            // 有id，则更新
            projectBaseinfoVO.getCustomer().setProjectId("[1,2]");
            resultCount = customerMapper.updateByPrimaryKeySelective(projectBaseinfoVO.getCustomer());

            if (resultCount == 0) {
                return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
            }
        }

        /***** 1. ProjectBaseinfo Object Save *****/
        ProjectBaseinfo projectBaseinfo = new ProjectBaseinfo();
        // -- 프로젝트 코드
        projectBaseinfo.setProjectCd(projectBaseinfoVO.getProjectCd());
        // -- 프로젝트명
        projectBaseinfo.setProjectName(projectBaseinfoVO.getProjectName());
        // -- 프로젝트 고객명
        projectBaseinfo.setProjectCustomer(String.valueOf(projectBaseinfoVO.getCustomer().getId()));
        // -- 프로젝트 영업담당자
        projectBaseinfo.setProjectSalesMan(projectBaseinfoVO.getProjectSalesMan());
        // -- 프로젝트 예상총매출
        projectBaseinfo.setProjectPriceTotal(projectBaseinfoVO.getProjectPriceTotal());
        // -- 프로젝트 상태
        projectBaseinfo.setProjectStatus(Const.ProjectStatus.KICKOFF);
        // -- 프로젝트 생산기지
        projectBaseinfo.setProjectLocation(projectBaseinfoVO.getProjectLocation());
        // -- 渠道
        projectBaseinfo.setDistribution(projectBaseinfoVO.getDistribution());
        // -- 프로젝트 시작일
        projectBaseinfo.setProjectStarttime(projectBaseinfoVO.getProjectStarttime());
        // -- 프로젝트 예상마감일
        projectBaseinfo.setProjectEndtime(projectBaseinfoVO.getProjectEndtime());
        // 저장
        resultCount = projectBaseinfoMapper.insert(projectBaseinfo);
        log.info("projectBaseinfo insert ok, id : {}",projectBaseinfo.getId());
        log.info("projectBaseinfo resultCount: {}",resultCount);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("数据保存失败");
        }

        // -- 프로젝트아이디 매핑시킨다
        projectBaseinfoVO.setId(projectBaseinfo.getId());

        return ServerResponse.createBySuccess(projectBaseinfoVO);
    }

    @Override
    @Transactional
    public ServerResponse update(ProjectBaseinfoVO projectBaseinfoVO) {
        if (projectBaseinfoVO == null) {
            return ServerResponse.createByErrorMessage(Const.Message.UPDATE_ERROR);
        }

//        int updateCount = projectBaseinfoMapper.updateByPrimaryKeySelective(projectBaseinfoVO);
        int resultCount = 0;
        /***** 2. ProjectCustomer Object Save *****/
        if (projectBaseinfoVO.getCustomer().getId() == null || "".equals(projectBaseinfoVO.getCustomer().getId())) {
            // 如果没有id，则新增
            Customer customer = new Customer();
//            customer.setId(projectBaseinfoVO.getCustomer().getId());
//            customer.setProjectId(projectBaseinfoVO.getCustomer().getProjectId());
            customer.setCustomerName(projectBaseinfoVO.getCustomer().getCustomerName());
            customer.setCustomerNameKr(projectBaseinfoVO.getCustomer().getCustomerNameKr());
            customer.setCustomerCd(projectBaseinfoVO.getCustomer().getCustomerCd());
            customer.setAuthor(projectBaseinfoVO.getCurrentUser().getRealname());
            customer.setDirector(projectBaseinfoVO.getCustomer().getDirector());
            customer.setStatus(Const.Status.ACTIVE);
            customer.setCustomerType(projectBaseinfoVO.getCustomer().getCustomerType());
            customer.setPhone(projectBaseinfoVO.getCustomer().getPhone());
            customer.setWechat(projectBaseinfoVO.getCustomer().getWechat());
            customer.setDescription(projectBaseinfoVO.getCustomer().getDescription());
            customer.setSalesVolumn(projectBaseinfoVO.getCustomer().getSalesVolumn());
            customer.setDevelopmentSkill(projectBaseinfoVO.getCustomer().getDevelopmentSkill());
            customer.setTarget(projectBaseinfoVO.getCustomer().getTarget());
            customer.setProductList(projectBaseinfoVO.getCustomer().getProductList());
            customer.setDistribution(projectBaseinfoVO.getCustomer().getDistribution());
            customer.setProvince(projectBaseinfoVO.getCustomer().getProvince());
            customer.setCity(projectBaseinfoVO.getCustomer().getCity());
            customer.setArea(projectBaseinfoVO.getCustomer().getArea());
            customer.setAddress(projectBaseinfoVO.getCustomer().getAddress());
            customer.setSalesMan(projectBaseinfoVO.getCustomer().getSalesMan());
            customer.setCustomerImage(projectBaseinfoVO.getCustomer().getCustomerImage());
            customer.setParam1(projectBaseinfoVO.getCustomer().getParam1());
            customer.setParam2(projectBaseinfoVO.getCustomer().getParam2());
            customer.setParam3(projectBaseinfoVO.getCustomer().getParam3());
            customer.setParam4(projectBaseinfoVO.getCustomer().getParam4());
            customer.setParam5(projectBaseinfoVO.getCustomer().getParam5());

            resultCount = customerMapper.insertWhenCreateNewProject(customer);
            projectBaseinfoVO.getCustomer().setId(customer.getId());

            if (resultCount == 0) {
                return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
            }

        } else {
            // 有id，则更新
            projectBaseinfoVO.getCustomer().setProjectId("[1,2]");
            resultCount = customerMapper.updateByPrimaryKeySelective(projectBaseinfoVO.getCustomer());

            if (resultCount == 0) {
                return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
            }
        }

        /***** 1. ProjectBaseinfo Object Save *****/
        ProjectBaseinfo projectBaseinfo = new ProjectBaseinfo();
        // -- Project ID
        projectBaseinfo.setId(projectBaseinfoVO.getId());
        // -- 프로젝트 코드
        projectBaseinfo.setProjectCd(projectBaseinfoVO.getProjectCd());
        // -- 프로젝트명
        projectBaseinfo.setProjectName(projectBaseinfoVO.getProjectName());
        // -- 프로젝트 고객명
        projectBaseinfo.setProjectCustomer(String.valueOf(projectBaseinfoVO.getCustomer().getId()));
        // -- 프로젝트 영업담당자
        projectBaseinfo.setProjectSalesMan(projectBaseinfoVO.getProjectSalesMan());
        // -- 프로젝트 예상총매출
        projectBaseinfo.setProjectPriceTotal(projectBaseinfoVO.getProjectPriceTotal());
        // -- 프로젝트 상태
        projectBaseinfo.setProjectStatus(Const.ProjectStatus.KICKOFF);
        // -- 프로젝트 생산기지
        projectBaseinfo.setProjectLocation(projectBaseinfoVO.getProjectLocation());
        // -- 渠道
        projectBaseinfo.setDistribution(projectBaseinfoVO.getDistribution());
        // -- 프로젝트 시작일
        projectBaseinfo.setProjectStarttime(projectBaseinfoVO.getProjectStarttime());
        // -- 프로젝트 예상마감일
        projectBaseinfo.setProjectEndtime(projectBaseinfoVO.getProjectEndtime());
        // 저장
        resultCount = projectBaseinfoMapper.updateByPrimaryKeySelective(projectBaseinfo);
        log.info("projectBaseinfo update ok, id : {}",projectBaseinfo.getId());
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("数据保存失败");
        }

        // -- 프로젝트아이디 매핑시킨다
        projectBaseinfoVO.setId(projectBaseinfo.getId());

//        if (updateCount == 0) {
//            return ServerResponse.createByErrorMessage(Const.Message.UPDATE_ERROR);
//        }
        return ServerResponse.createBySuccess(Const.Message.UPDATE_OK, projectBaseinfoVO);
    }

    @Override
    @Transactional
    public List<ProjectListVO> getProjectlist() {
        List<ProjectListVO> projectList = projectBaseinfoMapper.getProjetList();

        if (projectList != null && projectList.size() > 0) {
            return projectList;
        }
        return null;
    }

    @Override
    public ServerResponse getProjectCountByName(String projectName) {
        if (projectName == null || "".equals(projectName)) {
            return ServerResponse.createByErrorMessage(Const.Message.PARAMETER_ERROR);
        }

        int resultCount = projectBaseinfoMapper.getProjectCountByName(projectName);
        if (resultCount == 0) {
            return ServerResponse.createBySuccessMessage("OK");
        }
        return ServerResponse.createByErrorMessage("有重复名称， 请使用其他项目名");
    }


}
