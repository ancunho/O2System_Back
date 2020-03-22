package com.business.management.dao;

import com.business.management.pojo.ProjectCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("projectCustomerMapper")
public interface ProjectCustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectCustomer record);

    int insertSelective(ProjectCustomer record);

    ProjectCustomer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectCustomer record);

    int updateByPrimaryKey(ProjectCustomer record);
}