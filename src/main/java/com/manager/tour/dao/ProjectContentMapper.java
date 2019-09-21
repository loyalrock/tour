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

    /**
     * 批量新增
     * @param projectContents
     * @return
     */
    int insertAll(@Param("projectContents") List<ProjectContent> projectContents);

    ProjectContent selectDetail(@Param("sc0201Id") String sc0201Id);

    int deleteAll(@Param("projectNo") String projectNo, @Param("ids") List<String> ids, @Param("ss01Id") String userUid);

    List<String> selectDeleteId(@Param("projectNo") String projectNo, @Param("ids") List<String> ids);

    List<ProjectContent> selectProjectContentLevel(@Param("projectNo") String projectNo, @Param("code") String code, @Param("level") String level);
}
