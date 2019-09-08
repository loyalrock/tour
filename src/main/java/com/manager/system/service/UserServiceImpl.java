package com.manager.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.CommonException;
import com.manager.entry.system.*;
import com.manager.system.dao.UserMapper;
import com.manager.system.dao.UserProjectMapper;
import com.manager.system.dao.UserRoleMapper;
import com.manager.util.Delete;
import com.manager.util.Message;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.Subject;
import java.util.Date;
import java.util.UUID;

/**
 * UserService实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserProjectMapper userProjectMapper;

    @Override
    public int updateUser(UserManager userManager) throws Exception {

        String userUid = userManager.getSs01Id();
        UserManager beforeUpdateUser = userMapper.selectUserManagerDetail(userUid);

        // 当前登录用户
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        // 当前时间 修改时间
        Date now = new Date();

        int count = 0;

        // 判断姓名和登录账号是否相同
        if (!userManager.getUserName().equals(beforeUpdateUser.getUserName()) || !userManager.getUserId().equals(beforeUpdateUser.getUserId())) {
            User user = new User();
            user.setSs01Id(userUid);
            user.setUserName(userManager.getUserName());
            user.setUserId(userManager.getUserId());
            user.setUpdateUser(currentUser.getSs01Id());
            user.setUpdateTime(now);
            count = userMapper.updateByPrimaryKeySelective(user);
        }

        // 判断角色是否改变
        if (!userManager.getUserRoleId().equals(beforeUpdateUser.getUserRoleId())) {
            UserRole userRole = new UserRole();
            userRole.setSs01Id(userUid);
            userRole.setUserRoleId(userManager.getUserRoleId());
            userRole.setUpdateUser(currentUser.getSs01Id());
            userRole.setUpdateTime(now);
            count = userRoleMapper.updateByUserUid(userRole);
        }

        // 判断项目
        if (!userManager.getProjectNo().equals(beforeUpdateUser.getProjectNo()) || !userManager.getOpUnit().equals(beforeUpdateUser.getOpUnit())) {
            UserProject userProject = new UserProject();
            userProject.setSs01Id(userUid);
            userProject.setOpUnit(userManager.getOpUnit());
            userProject.setProjectNo(userManager.getProjectNo());
            userProject.setUpdateUser(currentUser.getSs01Id());
            userProject.setUpdateTime(now);
            count = userProjectMapper.updateByUserUid(userProject);
        }

        return count;
    }

    @Override
    public IPage<UserManager> selectUserManagerList(Page<UserManager> page, UserManagerQuery query) {
        return userMapper.selectUserManagerList(page, query);
    }

    @Override
    public User selectUserByUserId(String userId) {
        return userMapper.selectUserByUserId(userId);
    }

    @Override
    public int updateStatus(String userUid, String status) throws Exception {
        return userMapper.updateStatus(status, userUid);
    }

    @Override
    public int addUser(UserManager userManager) throws Exception {
        // 校验userUid 是否存在
        User checkUser = userMapper.selectUserByUserId(userManager.getUserId());
        if (checkUser != null) {
            // 存在
            throw new CommonException(Message.EXIST_USER);
        }

        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        Date now = new Date();
        String newUserUid = UUID.randomUUID().toString();
        User user = new User(
                newUserUid,
                userManager.getUserId(),
                userManager.getUserName(),
                "123456",
                User.ENABLE,
                currentUser.getSs01Id(),
                now,
                currentUser.getSs01Id(),
                now,
                Delete.UN_DELETE);

        // 新增用户表
        int count = userMapper.insertSelective(user);

        UserRole userRole = new UserRole(
                UUID.randomUUID().toString(),
                newUserUid,
                userManager.getUserRoleId(),
                currentUser.getSs01Id(),
                now,
                currentUser.getSs01Id(),
                now,
                Delete.UN_DELETE);
        // 新增用户角色表
        count = userRoleMapper.insertSelective(userRole);

        UserProject userProject = new UserProject(
                UUID.randomUUID().toString(),
                newUserUid,
                userManager.getProjectNo(),
                userManager.getOpUnit(),
                currentUser.getSs01Id(),
                now,
                currentUser.getSs01Id(),
                now,
                Delete.UN_DELETE);
        // 新增用户项目关联
        count = userProjectMapper.insertSelective(userProject);
        return count;
    }
}
