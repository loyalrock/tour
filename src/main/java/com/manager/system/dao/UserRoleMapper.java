package com.manager.system.dao;

import com.manager.entry.system.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}