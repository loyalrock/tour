package com.manager.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.CommonException;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.system.User;
import com.manager.entry.system.UserManager;
import com.manager.entry.system.UserManagerQuery;
import com.manager.system.service.UserService;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import com.manager.util.Role;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户详情
     *
     * @return
     */
    @RequestMapping("/detail")
    @RequiresAuthentication
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry insertUser(@Valid @RequestBody UserManager userManager) throws Exception {
        userService.addUser(userManager);
        return ResultUtil.success(Message.INSERT_SUCCESS);
    }

    @RequestMapping(value = "/status/update", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry updateStatus(@RequestParam("status") String status, @RequestParam("userUid") String userUid) throws Exception {
        userService.updateStatus(userUid, status);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }
}
