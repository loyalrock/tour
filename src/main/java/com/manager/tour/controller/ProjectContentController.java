package com.manager.tour.controller;

import com.manager.entry.common.ResultEntry;
import com.manager.entry.tour.ProjectContent;
import com.manager.tour.service.ProjectContentService;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import com.manager.util.Role;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 项目内容维护
 *
 * @author nosign
 * @date 2019/09/16
 */
@RestController
@RequestMapping("/project/content")
public class ProjectContentController {

    @Autowired
    private ProjectContentService projectContentService;

    /**
     * 修改关联内容中的项
     *
     * @param projectContent
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultEntry updateProjectContent(@RequestBody ProjectContent projectContent) throws Exception {
        projectContentService.update(projectContent);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 查询详情
     *
     * @param sc0201Id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT, Role.EXPERTS}, logical = Logical.OR)
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResultEntry updateProjectContent(@RequestParam("sc0201Id") @NotBlank(message = "缺失主键") String sc0201Id) throws Exception {
        ProjectContent projectContent = projectContentService.selectDetail(sc0201Id);
        return ResultUtil.success(Message.SELECT_SUCCESS, projectContent);
    }

    /**
     * 查询详情
     *
     * @param sc0201Id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT, Role.EXPERTS}, logical = Logical.OR)
    @RequestMapping(value = "/score", method = RequestMethod.POST)
    public ResultEntry updateProjectContent(@RequestParam("sc0201Id") @NotBlank(message = "缺失主键") String sc0201Id,
                                            @RequestParam("score") @Min(value = 0, message = "分数不能小于0") @NotNull(message = "分数不能为空") Integer score) throws Exception {
        int count = projectContentService.updateScore(sc0201Id, score);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 查询当前项目下的项目内容
     * @param projectNo
     * @param code
     * @param level
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT, Role.EXPERTS}, logical = Logical.OR)
    @RequestMapping(value = "/level", method = RequestMethod.GET)
    public ResultEntry selectProjectContentList(@RequestParam(required = false, value = "projectNo") String projectNo,
                                                @RequestParam(required = false, value = "code") String code,
                                                @RequestParam(defaultValue = "1") String level) throws Exception {
        List<ProjectContent> projectContentList = projectContentService.selectProjectContentLevel(projectNo, code, level);
        return ResultUtil.success(Message.SELECT_SUCCESS, projectContentList);
    }

}
