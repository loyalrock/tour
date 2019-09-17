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

/**
 * 项目内容维护
 *
 * @auth0r nosign
 * @date 2019/09/16
 */
@RestController
@RequestMapping("/project/content")
public class ProjectContentController {

    @Autowired
    private ProjectContentService projectContentService;

    /**
     * 修改关联内容中的项
     * @param projectContent
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultEntry updateProjectContent (@RequestBody ProjectContent projectContent) throws Exception {
        projectContentService.update(projectContent);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 查询详情
     * @param sc0201Id
     * @return
     * @throws Exception
     */
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResultEntry updateProjectContent (@RequestParam("sc0201Id") String sc0201Id) throws Exception {
        ProjectContent projectContent = projectContentService.selectDetail(sc0201Id);
        return ResultUtil.success(Message.SELECT_SUCCESS, projectContent);
    }

}
