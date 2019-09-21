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

//    /**
//     * 上传首页图片
//     * @param file
//     * @param projectNo
//     * @return
//     * @throws Exception
//     */
//    int uploadIndex(MultipartFile file, String projectNo) throws Exception;

    int deleteAll(List<String> ids);

    int deleteOne(String sc02Id);

    int updateStatus(ProjectJobQuery query);

    ProjectJob selectDetail(String sc02Id);

    /**
     * 修改项目内容
     * @param projectJob
     * @return
     */
    int update(ProjectJob projectJob);

    /**
     * 检测项目简称是否重复
     * @param code
     * @return
     */
    int checkProjectNameShort(String code);

    /**
     * 查询该项目的首页图片
     * @param code
     * @return
     */
    List<String> selectIndexPics(String code);

}
