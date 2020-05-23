package com.business.management.dao;

import com.business.management.pojo.ProjectFileinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("projectFileinfoMapper")
public interface ProjectFileinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectFileinfo record);

    int insertSelective(ProjectFileinfo record);

    ProjectFileinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectFileinfo record);

    int updateByPrimaryKey(ProjectFileinfo record);

    List<ProjectFileinfo> selectByProjectId(Integer projectId);

}