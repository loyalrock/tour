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
import com.manager.util.group.InsertGroup;
import com.manager.util.group.UpdateGroup;
import com.manager.util.group.UpdateStatusGroup;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
     * 查询所有列表 新增用户时使用 选择项目
     *
     * @return
     */
    @RequiresRoles(value = {Role.SYSTEM})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultEntry getProjectJobList() {
        List<ProjectJob> projectJobs = projectJobService.selectList();
        return ResultUtil.success(Message.SELECT_SUCCESS, projectJobs);
    }

    /**
     * 查询分页
     *
     * @return
     */
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
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
    @RequiresRoles(value = {Role.SYSTEM}, logical = Logical.OR)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultEntry add(@RequestBody @Validated(value = {InsertGroup.class}) ProjectJob projectJob) throws Exception {
        projectJobService.add(projectJob);
        return ResultUtil.success(Message.INSERT_SUCCESS);
    }

    /**
     * 修改
     *
     * @param projectJob
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultEntry update(@RequestBody @Validated(value = {UpdateGroup.class}) ProjectJob projectJob) throws Exception {
        projectJobService.update(projectJob);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 删除一个
     *
     * @param sc02Id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM}, logical = Logical.OR)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultEntry delete(@RequestParam("sc02Id") @NotBlank(message = "缺失主键") String sc02Id) throws Exception {
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
    @RequiresRoles(value = {Role.SYSTEM}, logical = Logical.OR)
    @RequestMapping(value = "/delete/all", method = RequestMethod.POST)
    public ResultEntry deleteAll(@NotEmpty(message = "缺失删除列表") List<String> ids) throws Exception {
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
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    @RequestMapping(value = "/update/status", method = RequestMethod.POST)
    public ResultEntry updateStatus(@RequestBody @Validated(value = {UpdateStatusGroup.class}) ProjectJobQuery query) throws Exception {
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
    public ResultEntry getNextCode() {
        String code = projectJobService.getNextCode();
        return ResultUtil.success(Message.SELECT_SUCCESS, code);
    }

    /**
     * 详情
     * @param sc02Id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResultEntry selectDetail(@RequestParam("sc02Id") @NotBlank(message = "缺失主键") String sc02Id) throws Exception {
        ProjectJob projectJob = projectJobService.selectDetail(sc02Id);
        return ResultUtil.success(Message.SELECT_SUCCESS, projectJob);
    }

    /**
     * 检测项目简称是否重复
     * 如果大于0 重复  等于0可以使用
     * @param projectNameJ
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM}, logical = Logical.OR)
    @RequestMapping(value = "/check/short", method = RequestMethod.GET)
    public ResultEntry checkProjectNameJ(@RequestParam("projectNameJ") @NotBlank(message = "项目简称缺失") String projectNameJ) throws Exception {
        int count = projectJobService.checkProjectNameShort(projectNameJ);
        return ResultUtil.success(Message.SELECT_SUCCESS, count);
    }

    /**
     * 查询项目下的图片
     * shiro 不校验
     * @param projectNameJ
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResultEntry selectProjectIndexPic(@RequestParam("projectNameJ") @NotBlank(message = "项目简称缺失") String projectNameJ) throws Exception {
        List<String> pics = projectJobService.selectIndexPics(projectNameJ);
        return ResultUtil.success(Message.SELECT_SUCCESS, pics);
    }


}
