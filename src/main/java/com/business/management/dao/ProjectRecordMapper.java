package com.business.management.dao;

import com.business.management.pojo.ProjectRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Component("projectRecordMapper")
public interface ProjectRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectRecord record);

    int insertSelective(ProjectRecord record);

    ProjectRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectRecord record);

    int updateByPrimaryKey(ProjectRecord record);

    List<ProjectRecord> selectByProjectId(@RequestParam(value = "projectId") Integer projectId);
}