package com.manager.system.service;

import com.manager.entry.system.User;
import com.manager.entry.system.UserManager;
import com.manager.entry.system.UserManagerQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User接口累
 */
public interface UserService {

    /**
     * 查询User详情
     * @param userId
     * @return
     */
    public User selectUserByUserId(String userId);

    List<UserManager> selectUserManagerList(UserManagerQuery query);
}
