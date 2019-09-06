package com.manager.system.dao;

import com.manager.entry.system.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String ss02Id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String ss02Id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    @Select("select * from SS02 where SS01_ID = #{userUid}")
    @ResultMap("BaseResultMap")
    Role selectRoleByUserUid(@Param("userUid") String userUid);

    @Select("select * from SS02")
    @ResultMap("BaseResultMap")
    List<Role> selectList();
}