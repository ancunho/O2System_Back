package com.business.management.dao;

import com.business.management.pojo.Customer;
import com.business.management.pojo.ProjectBaseinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("customerMapper")
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertWhenCreateNewProject(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> selectCustomerList();

    List<Customer> getCustomerListOnlyIDAndName();

    Customer selectByCustomerName(String customerName);

    Customer selectByCustomerId(Integer customerId);

    int checkCustomerName(@Param(value = "customerName") String customerName);

    List<ProjectBaseinfo> selectProjectListByCustomerId(@Param(value = "customerId") Integer customerId);




}