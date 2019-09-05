package com.manager.tour.dao;

import com.manager.entry.tour.ProjectJob;

public interface ProjectJobMapper {
    int deleteByPrimaryKey(String sc02Id);

    int insert(ProjectJob record);

    int insertSelective(ProjectJob record);

    ProjectJob selectByPrimaryKey(String sc02Id);

    int updateByPrimaryKeySelective(ProjectJob record);

    int updateByPrimaryKey(ProjectJob record);
}