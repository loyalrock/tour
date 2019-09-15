package com.manager.tour.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.tour.ProjectJob;
import com.manager.entry.tour.ProjectJobQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 项目 service
 * @author zhongyan
 */
public interface ProjectJobService {

    List<ProjectJob> selectList();

    int add(ProjectJob projectJob);

    IPage<ProjectJob> selectPage(Page<ProjectJob> page, ProjectJobQuery query);

    String getNextCode();

    int uploadFile(MultipartFile file, String projectNo, String type) throws Exception;

    int deleteAll(List<String> ids);

    int deleteOne(String sc02Id);

    int updateStatus(ProjectJobQuery query);

    ProjectJob selectDetail(String sc02Id);

}
