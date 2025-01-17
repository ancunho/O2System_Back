package com.business.management.service.impl;

import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.dao.CustomerMapper;
import com.business.management.pojo.Customer;
import com.business.management.pojo.ProjectBaseinfo;
import com.business.management.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Cunho
 * @date : 2020/3/25
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public ServerResponse customerList() {
//        PageHelper.startPage(pageNum, pageSize);
        List<Customer> customerList = customerMapper.selectCustomerList();
//        PageInfo pageResult = new PageInfo(customerList);
//        pageResult.setList(customerList);

        return ServerResponse.createBySuccess(customerList);
    }

    @Override
    public ServerResponse getCustomerListOnlyIDAndName() {
        List<Customer> customerList = customerMapper.getCustomerListOnlyIDAndName();
        return ServerResponse.createBySuccess(customerList);
    }

    @Override
    public ServerResponse detail(Integer id) {
        if (id == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        Customer customer = customerMapper.selectByPrimaryKey(id);

        if (customer == null) {
            return ServerResponse.createByErrorMessage(Const.Message.SELECT_ERROR);
        }

        return ServerResponse.createBySuccess(customer);
    }

    @Override
    public ServerResponse create(Customer customer) {
        if (customer != null) {
            // New
            if (customer.getCustomerName() != null || !"".equals(customer.getCustomerName())) {
                int resultCount = customerMapper.insert(customer);
                if (resultCount > 0) {
                    return ServerResponse.createBySuccessMessage(Const.Message.SAVE_OK);
                } else {
                    return ServerResponse.createByErrorMessage(Const.Message.SAVE_ERROR);
                }
            } else {
                return ServerResponse.createByErrorMessage(Const.Message.PARAMETER_ERROR);
            }
        } else {
            return ServerResponse.createByErrorMessage(Const.Message.PARAMETER_ERROR);
        }
    }

    @Override
    public ServerResponse update(Customer customer) {
        if (customer != null) {
            if (customer.getId() != null) {
                // Modify
                int resultCount = customerMapper.updateByPrimaryKeySelective(customer);
                if (resultCount > 0) {
                    return ServerResponse.createBySuccessMessage(Const.Message.UPDATE_OK);
                }
                return ServerResponse.createByErrorMessage(Const.Message.UPDATE_ERROR);
            } else {
                return ServerResponse.createByErrorMessage("客户数据已存在，请返回列表仔细查看");
            }
        } else {
            return ServerResponse.createByErrorMessage(Const.Message.PARAMETER_ERROR);
        }
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public ServerResponse<String> checkCustomerName(String str, String type) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(type)) {
            //고객명 체크
            if (Const.CUSTOMER_NAME.equals(type)) {
                int resultCount = customerMapper.checkCustomerName(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("客户名已存在，请先查询是否已录入此客户信息");
                } else {
                    return ServerResponse.createBySuccessMessage("客户名不存在，可以使用");
                }
            } else {
                return ServerResponse.createBySuccessMessage(Const.Message.PARAMETER_ERROR);
            }
        } else {
            return ServerResponse.createByErrorMessage(Const.Message.PARAMETER_ERROR);
        }
    }

    @Override
    public ServerResponse<String> checkCustomerCode(String str, String type) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(type)) {
            //고객명 체크
            if (Const.CUSTOMER_CD.equals(type)) {
                int resultCount = customerMapper.checkCustomerCd(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("客户编号已存在，请先查询是否已录入此客户信息");
                } else {
                    return ServerResponse.createBySuccessMessage("客户编号不存在，可以使用");
                }
            } else {
                return ServerResponse.createBySuccessMessage(Const.Message.PARAMETER_ERROR);
            }
        } else {
            return ServerResponse.createByErrorMessage(Const.Message.PARAMETER_ERROR);
        }
    }

    @Override
    public ServerResponse selectProjectListByCustomerId(Integer customerId) {
        if (customerId == null) {
            return ServerResponse.createByErrorMessage(Const.Message.PARAMETER_ERROR);
        }

        List<ProjectBaseinfo> projectBaseinfoList = customerMapper.selectProjectListByCustomerId(customerId);
        if (projectBaseinfoList != null) {
            return ServerResponse.createBySuccess(Const.Message.SELECT_OK, projectBaseinfoList);
        }
        return ServerResponse.createByErrorMessage(Const.Message.SELECT_ERROR);
    }

}
