package com.manager.tour.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.tour.ProjectJob;
import com.manager.entry.tour.ProjectJobQuery;
import com.manager.tour.service.ProjectJobService;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import com.manager.util.Role;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * 项目
 * 1.列表查询（项目名称） 修改 删除 新增
 * 2.暂停、恢复项目
 * 3.维护创建内容
 *
 * @author zhongyan
 */
@RestController
@RequestMapping("/project")
public class ProjectJobController {

    @Autowired
    private ProjectJobService projectJobService;

    /**
     * 查询所有列表
     *
     * @return
     */
    @RequiresRoles(value = {"SYS_ADMIN"})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultEntry getProjectJobList() {
        List<ProjectJob> projectJobs = projectJobService.selectList();
        return ResultUtil.success(Message.SELECT_SUCCESS, projectJobs);
    }

    /**
     * 查询所有列表
     *
     * @return
     */
    @RequiresRoles(value = {"SYS_ADMIN"})
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResultEntry getProjectJobPage(Page<ProjectJob> page, ProjectJobQuery query) {
        IPage<ProjectJob> projectJobIPage = projectJobService.selectPage(page, query);
        return ResultUtil.success(Message.SELECT_SUCCESS, projectJobIPage);
    }

    /**
     * 新增
     *
     * @param projectJob
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultEntry add(@RequestBody ProjectJob projectJob) throws Exception {
        projectJobService.add(projectJob);
        return ResultUtil.success(Message.INSERT_SUCCESS);
    }

    /**
     * 上传文件
     *
     * @param file
     * @param projectNo
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM})
    @RequestMapping(value = "/upload/index", method = RequestMethod.POST)
    public ResultEntry upload(@RequestParam("file") MultipartFile file,  @RequestParam("projectNo") String projectNo) throws Exception {
        projectJobService.uploadIndex(file, projectNo);
        return ResultUtil.success(Message.SUCCESS);
    }

    /**
     * 删除一个
     *
     * @param sc02Id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM})
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultEntry delete(@RequestParam("sc02Id") String sc02Id) throws Exception {
        projectJobService.deleteOne(sc02Id);
        return ResultUtil.success(Message.DELETE_SUCCESS);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM})
    @RequestMapping(value = "/delete/all", method = RequestMethod.POST)
    public ResultEntry deleteAll(List<String> ids) throws Exception {
        projectJobService.deleteAll(ids);
        return ResultUtil.success(Message.DELETE_SUCCESS);
    }

    /**
     * 修改状态
     *
     * @param query
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM})
    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    public ResultEntry updateStatus(@RequestBody ProjectJobQuery query) throws Exception {
        projectJobService.updateStatus(query);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 获取下一个新增的code
     *
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM})
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public ResultEntry getNextCode() throws Exception {
        String code = projectJobService.getNextCode();
        return ResultUtil.success(Message.SELECT_SUCCESS, code);
    }

    /**
     * 详情
     * @param sc02Id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM})
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResultEntry selectDetail(@RequestParam("sc02Id") String sc02Id) throws Exception {
        ProjectJob projectJob = projectJobService.selectDetail(sc02Id);
        return ResultUtil.success(Message.SELECT_SUCCESS, projectJob);
    }
}
