package com.business.management.dao;

import com.business.management.pojo.ProjectProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("projectProductMapper")
public interface ProjectProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectProduct record);

    int insertSelective(ProjectProduct record);

    ProjectProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectProduct record);

    int updateByPrimaryKey(ProjectProduct record);
}