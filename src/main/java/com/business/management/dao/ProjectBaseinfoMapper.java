package com.business.management.dao;

import com.business.management.pojo.ProjectBaseinfo;
import com.business.management.vo.ProjectListVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("projectBaseinfoMapper")
public interface ProjectBaseinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectBaseinfo record);

    int insertSelective(ProjectBaseinfo record);

    ProjectBaseinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectBaseinfo record);

    int updateByPrimaryKey(ProjectBaseinfo record);

    List<ProjectListVO> getList();
}