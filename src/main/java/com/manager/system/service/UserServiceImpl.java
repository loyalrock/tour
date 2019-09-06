package com.manager.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.system.User;
import com.manager.entry.system.UserManager;
import com.manager.entry.system.UserManagerQuery;
import com.manager.system.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<UserManager> selectUserManagerList(Page<UserManager> page, UserManagerQuery query) {
        return userMapper.selectUserManagerList(page, query);
    }

    @Override
    public User selectUserByUserId(String userId) {
        return userMapper.selectUserByUserId(userId);
    }
}
