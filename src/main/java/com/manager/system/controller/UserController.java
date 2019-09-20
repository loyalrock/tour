package com.manager.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.system.User;
import com.manager.entry.system.UserManager;
import com.manager.entry.system.UserManagerQuery;
import com.manager.system.service.UserService;
import com.manager.util.*;
import com.manager.util.group.InsertGroup;
import com.manager.util.group.UpdateGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    public ResultEntry getUserManagerList(Page page, UserManagerQuery query) {
        IPage<UserManager> userManagers = userService.selectUserManagerList(page, query);
        return ResultUtil.success(Message.SELECT_SUCCESS, userManagers);
    }

    /**
     * 获取用户管理详情
     *
     * @param userUid
     * @return
     */
    @RequestMapping(value = "/manager/detail", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    public ResultEntry getUserManagerList(@Param("userUid") String userUid) throws Exception {
        UserManager userManager = userService.selectUserManagerDetail(userUid);
        return ResultUtil.success(Message.SELECT_SUCCESS, userManager);
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

    /**
     * 用户状态修改
     * @param status
     * @param userUid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/status/update", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry updateStatus(@RequestParam("status") String status, @RequestParam("userUid") String userUid) throws Exception {
        userService.updateStatus(userUid, status);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/pw/update", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    public ResultEntry upload(@Param("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) throws Exception{
        userService.updatePassword(oldPassword, newPassword);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }
}
