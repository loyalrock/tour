package com.manager.tour.service;

import com.manager.entry.tour.ProjectContent;

import java.util.List;

/**
 * 项目内容维护service
 *
 * @author nosign
 * @date 2019/09/16
 */
public interface ProjectContentService {

    /**
     * 查询当前项目下关联内容的详情
     * @param sc0201Id
     * @return
     */
    ProjectContent selectDetail(String sc0201Id);

    int update(ProjectContent projectContent);

    /**
     * 打分
     * @param sc0201Id
     * @param score
     * @return
     */
    int updateScore(String sc0201Id, Integer score);

    /**
     * 查询项目下的维护内容列表
     * @param projectNo
     * @param code
     * @param level
     * @return
     */
    List<ProjectContent> selectProjectContentLevel(String projectNo, String code, String level);

}
