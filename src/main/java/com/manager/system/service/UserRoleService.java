package com.manager.system.service;

import com.manager.entry.system.UserRole;

import java.util.List;

/**
 * 用户角色
 */
public interface UserRoleService {

    List<UserRole> selectUserRoleByUserUid(String userUid);
}
