package com.business.management.dao;

import com.business.management.pojo.ProjectSalesman;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("projectSalesmanMapper")
public interface ProjectSalesmanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectSalesman record);

    int insertSelective(ProjectSalesman record);

    ProjectSalesman selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectSalesman record);

    int updateByPrimaryKey(ProjectSalesman record);
}