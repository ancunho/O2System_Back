package com.business.management.dao;

import com.business.management.pojo.ProjectBaseinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("projectBaseinfoMapper")
public interface ProjectBaseinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectBaseinfo record);

    int insertSelective(ProjectBaseinfo record);

    ProjectBaseinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectBaseinfo record);

    int updateByPrimaryKey(ProjectBaseinfo record);
}