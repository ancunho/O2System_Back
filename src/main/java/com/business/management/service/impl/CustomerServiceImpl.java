package com.business.management.service.impl;

import com.business.management.common.Const;
import com.business.management.common.ResponseCode;
import com.business.management.common.ServerResponse;
import com.business.management.dao.CustomerMapper;
import com.business.management.pojo.Customer;
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

}
