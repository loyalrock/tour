package com.manager.system.controller;

import com.manager.entry.common.CommonException;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.system.UserManager;
import com.manager.entry.system.UserManagerQuery;
import com.manager.system.service.UserService;
import com.manager.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户详情
     * @return
     */
    @RequestMapping("detail")
    @RequiresAuthentication
    public ResultEntry getUserDetail (Principal principal) {
        return ResultUtil.success(principal);
    }

    /**
     * 获取用户管理列表
     * @param query
     * @return
     */
    @RequestMapping(value = "/manager/list", method = RequestMethod.GET)
    @RequiresRoles(value = {"SYS_ADMIN"})
    public ResultEntry getUserManagerList(UserManagerQuery query) {
        List<UserManager> userManagers = userService.selectUserManagerList(query);
        return ResultUtil.success(userManagers);
    }
}
