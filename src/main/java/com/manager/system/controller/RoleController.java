package com.manager.system.controller;

import com.manager.entry.common.ResultEntry;
import com.manager.entry.system.Role;
import com.manager.system.service.RoleService;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色列表
     * @return
     */
    @RequestMapping("/list")
    @RequiresRoles(value = {"SYS_ADMIN"})
    public ResultEntry getRoleList() {
        List<Role> roleList = roleService.selectRoleList();
        return ResultUtil.success(Message.SELECT_SUCCESS, roleList);
    }

    // TODO 角色增删改
}
