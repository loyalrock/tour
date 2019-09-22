package com.manager.system.service;

import com.manager.entry.system.Role;

import java.util.List;

public interface RoleService {

    /**
     * 查询角色详情
     * @param userUid
     * @return
     */
    public Role selectRoleByUserUid(String userUid);

    /**
     * 查询角色列表
     * @return
     */
    List<Role> selectRoleList();

    int updateRole(Role role);
}
