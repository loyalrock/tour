package com.manager.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.system.User;
import com.manager.entry.system.UserManager;
import com.manager.entry.system.UserManagerQuery;
import org.apache.ibatis.annotations.Param;

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

    User selectUserByUserId(@Param("userId") String userId);

    /**
     * 分页查询
     * @param page
     * @param query
     * @return
     */
    IPage<UserManager> selectUserManagerList(Page page, @Param("query") UserManagerQuery query);
}
