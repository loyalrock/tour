package com.manager.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.CommonException;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.system.User;
import com.manager.entry.system.UserManager;
import com.manager.entry.system.UserManagerQuery;
import com.manager.system.service.UserService;
import com.manager.util.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiresAuthentication
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户详情
     *
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResultEntry getUserDetail(Principal principal) {
        return ResultUtil.success(Message.SELECT_SUCCESS, principal);
    }

    /**
     * 获取用户管理列表
     *
     * @param query
     * @return
     */
    @RequestMapping(value = "/manager/page", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry getUserManagerList(Page page, UserManagerQuery query) {
        IPage<UserManager> userManagers = userService.selectUserManagerList(page, query);
        return ResultUtil.success(Message.SELECT_SUCCESS, userManagers);
    }

    /**
     * 新增用户 角色 和 关联项目
     * @param userManager
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry insertUser(@Validated(InsertGroup.class) @RequestBody UserManager userManager) throws Exception {
        userService.addUser(userManager);
        return ResultUtil.success(Message.INSERT_SUCCESS);
    }

    /**
     * 修改角色角色 登录名称 登录Id 及 关联项目单位
     * @param userManager
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry updateUser(@Validated(UpdateGroup.class) @RequestBody UserManager userManager) throws Exception {
        userService.updateUser(userManager);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    @RequestMapping(value = "/status/update", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry updateStatus(@RequestParam("status") String status, @RequestParam("userUid") String userUid) throws Exception {
        userService.updateStatus(userUid, status);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }
}
