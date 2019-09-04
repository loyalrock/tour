package com.manager.system.service;

import com.manager.entry.system.UserRole;

/**
 * 用户角色
 */
public interface UserRoleService {

    UserRole selectUserRoleByUserUid(String userUid);
}
