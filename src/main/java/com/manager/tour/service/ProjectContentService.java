package com.manager.tour.service;

import com.manager.entry.tour.ProjectContent;

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
}
