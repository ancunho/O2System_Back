package com.business.management.dao;

import com.business.management.pojo.ProjectTimeline;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("projectTimelineMapper")
public interface ProjectTimelineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectTimeline record);

    int insertSelective(ProjectTimeline record);

    ProjectTimeline selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectTimeline record);

    int updateByPrimaryKey(ProjectTimeline record);
}