package com.manager.tour.dao;

import com.manager.entry.tour.ProjectContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectContentMapper {
    int deleteByPrimaryKey(String sc0201Id);

    int insert(ProjectContent record);

    int insertSelective(ProjectContent record);

    ProjectContent selectByPrimaryKey(String sc0201Id);

    int updateByPrimaryKeySelective(ProjectContent record);

    int updateByPrimaryKey(ProjectContent record);

    int insertAll(@Param("projectContents") List<ProjectContent> projectContents);
}
