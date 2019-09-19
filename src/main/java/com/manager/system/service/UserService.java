package com.manager.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.CommonException;
import com.manager.entry.system.User;
import com.manager.entry.system.UserManager;
import com.manager.entry.system.UserManagerQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    User selectUserByUserId(String userId);

    /**
     * 分页查询
     * @param page
     * @param query
     * @return
     */
    IPage<UserManager> selectUserManagerList(Page<UserManager> page, UserManagerQuery query);

    UserManager selectUserManagerDetail(String userUid) throws Exception;

    /**
     * 新增用户
     * @param userManager
     * @return
     */
    int addUser(UserManager userManager) throws Exception;

    int updateStatus(String userUid, String status) throws Exception;

    int updateUser(UserManager userManager) throws Exception;

}
