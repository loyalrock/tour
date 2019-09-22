package com.manager.system.controller;

import com.manager.entry.common.ResultEntry;
import com.manager.entry.system.Role;
import com.manager.system.service.RoleService;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import com.manager.util.group.UpdateGroup;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequiresRoles(value = {com.manager.util.Role.SYSTEM, com.manager.util.Role.PROJECT}, logical = Logical.OR)
    public ResultEntry getRoleList() {
        List<Role> roleList = roleService.selectRoleList();
        return ResultUtil.success(Message.SELECT_SUCCESS, roleList);
    }

    /**
     * 修改角色名称
     * @return
     */
    @RequestMapping("/update")
    @RequiresRoles(value = {com.manager.util.Role.SYSTEM})
    public ResultEntry updateRole(@RequestBody @Validated(value = {UpdateGroup.class}) Role role) {
        int count = roleService.updateRole(role);
        return ResultUtil.success(Message.UPDATE_SUCCESS, count);
    }
}
