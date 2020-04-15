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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        /***** 1. ProjectBaseinfo Object Save *****/
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
            return ServerResponse.createByErrorMessage("数据保存失败");
        }

        /***** 2. ProjectCustomer Object Save *****/
        if (projectBaseinfoVO.getProjectCustomer().getId() == null || "".equals(projectBaseinfoVO.getProjectCustomer().getId())) {
            // 如果没有id，则新增
            Customer customer = new Customer();
            customer.setId(projectBaseinfoVO.getProjectCustomer().getId());
            customer.setCustomerName(projectBaseinfoVO.getProjectCustomer().getCustomerName());
            customer.setCustomerCd(projectBaseinfoVO.getProjectCustomer().getCustomerCd());
            customer.setAuthor(projectBaseinfoVO.getCurrentUser().getRealname());
            customer.setDirector(projectBaseinfoVO.getProjectCustomer().getDirector());
            customer.setStatus(Const.Status.ACTIVE);
            customer.setPhone(projectBaseinfoVO.getProjectCustomer().getPhone());
            customer.setWechat(projectBaseinfoVO.getProjectCustomer().getWechat());
            customer.setDescription(projectBaseinfoVO.getProjectCustomer().getDescription());
            customer.setSalesVolumn(projectBaseinfoVO.getProjectCustomer().getSalesVolumn());
            customer.setDevelopmentSkill(projectBaseinfoVO.getProjectCustomer().getDevelopmentSkill());
            customer.setTarget(projectBaseinfoVO.getProjectCustomer().getTarget());
            customer.setProductList(projectBaseinfoVO.getProjectCustomer().getProductList());
            customer.setDistribution(projectBaseinfoVO.getProjectCustomer().getDistribution());
            customer.setProvince(projectBaseinfoVO.getProjectCustomer().getProvince());
            customer.setCity(projectBaseinfoVO.getProjectCustomer().getCity());
            customer.setArea(projectBaseinfoVO.getProjectCustomer().getArea());
            customer.setAddress(projectBaseinfoVO.getProjectCustomer().getAddress());
            customer.setSalesMan(projectBaseinfoVO.getProjectCustomer().getSalesMan());
            customer.setCustomerImage(projectBaseinfoVO.getProjectCustomer().getCustomerImage());
            resultCount = customerMapper.insert(customer);

            if (resultCount == 0) {
                return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
            }
            return ServerResponse.createBySuccessMessage(Const.Message.SAVE_OK);
        } else {
            // 有id，则更新
            resultCount = customerMapper.updateByPrimaryKeySelective(projectBaseinfoVO.getProjectCustomer());

            if (resultCount == 0) {
                return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
            }
            return ServerResponse.createBySuccessMessage(Const.Message.SAVE_OK);
        }
    }




}
