package com.manager.tour.controller;

import com.manager.entry.common.ResultEntry;
import com.manager.entry.tour.ProjectJob;
import com.manager.tour.service.ProjectJobService;
import com.manager.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目
 * @author zhongyan
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectJobService projectJobService;

    /**
     * 查询所有列表
     * @return
     */
    @RequiresRoles(value = {"SYS_ADMIN"})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultEntry getProjectJobList() {
        List<ProjectJob> projectJobs = projectJobService.selectList();
        return ResultUtil.success(projectJobs);
    }
}
