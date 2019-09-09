package com.manager.system.dao;

import com.manager.entry.system.User;
import com.manager.entry.system.UserRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(String ss0101Id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String ss0101Id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<UserRole> selectUserRoleByUserUid(@Param("userUid") String userUid);

    /**
     * 修改用户角色关系 通过SS01_ID
     * @param userRole
     * @return
     */
    int updateByUserUid(UserRole userRole);

    int deleteByUserUid(@Param("userUid") String userUid);
}
