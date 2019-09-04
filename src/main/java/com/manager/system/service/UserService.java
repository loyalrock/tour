package com.manager.system.service;

import com.manager.entry.system.User;
import org.springframework.stereotype.Service;

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
}
