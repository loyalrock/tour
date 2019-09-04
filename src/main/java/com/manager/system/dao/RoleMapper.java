package com.manager.system.dao;

import com.manager.entry.system.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String ss02Id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String ss02Id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Role selectRoleByUserUid(@Param("userUid") String userUid);

    List<Role> selectRoleList();
}