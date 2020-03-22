package com.business.management.dao;

import com.business.management.pojo.ProjectPrice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component("projectPriceMapper")
public interface ProjectPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPrice record);

    int insertSelective(ProjectPrice record);

    ProjectPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectPrice record);

    int updateByPrimaryKey(ProjectPrice record);
}