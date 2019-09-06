package com.manager.tour.dao;

import com.manager.entry.tour.ProjectJob;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectJobMapper {
    int deleteByPrimaryKey(String sc02Id);

    int insert(ProjectJob record);

    int insertSelective(ProjectJob record);

    ProjectJob selectByPrimaryKey(String sc02Id);

    int updateByPrimaryKeySelective(ProjectJob record);

    int updateByPrimaryKey(ProjectJob record);

    @ResultMap("BaseResultMap")
    @Select("select * from SC02")
    List<ProjectJob> selectList();
}