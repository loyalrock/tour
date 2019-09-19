package com.manager.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.system.User;
import com.manager.entry.system.UserManager;
import com.manager.entry.system.UserManagerQuery;
import org.apache.ibatis.annotations.*;

/**
 * mapper
 */
public interface UserMapper extends BaseMapper<UserManager> {
    int deleteByPrimaryKey(String ss01Id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String ss01Id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from SS01 where USER_ID = #{userId}")
    @ResultMap("BaseResultMap")
    User selectUserByUserId(@Param("userId") String userId);

    /**
     * 分页查询
     * @param page 分页查询
     * @param query 模糊查询
     * @param projectNo 如果是项目管理员 筛选当前所属项目的人员进行显示
     * @return
     */
    IPage<UserManager> selectUserManagerList(Page page, @Param("query") UserManagerQuery query, @Param("projectNo") String projectNo);

    UserManager selectUserManagerDetail(@Param("userUid") String userUid);

    @Update("update SS01 set STATUS = #{status} where SS01_ID = #{userUid}")
    int updateStatus(@Param("status") String status, @Param("userUid") String userUid);

}
