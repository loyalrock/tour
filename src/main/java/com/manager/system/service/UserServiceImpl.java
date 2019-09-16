package com.manager.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.CommonException;
import com.manager.entry.common.UserUtil;
import com.manager.entry.system.*;
import com.manager.system.dao.UserMapper;
import com.manager.system.dao.UserProjectMapper;
import com.manager.system.dao.UserRoleMapper;
import com.manager.util.Delete;
import com.manager.util.Message;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.Subject;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

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
        List<String> userRoles = Arrays.asList(userManager.getUserRoleId().split(","));
        HashSet<String> beforeUpdateRoles = new HashSet<>();
        for (UserRole userRole : beforeUpdateUser.getUserRoles()) {
            beforeUpdateRoles.add(userRole.getUserRoleId());
        }
        if (!beforeUpdateRoles.containsAll(userRoles)) {
            // 删除所有角色
            userRoleMapper.deleteByUserUid(userUid);

            // 新增
            for (String userRoleId : userRoles) {
                UserRole userRole = new UserRole();
                userRole.setSs0101Id(UUID.randomUUID().toString());
                userRole.setSs01Id(userUid);
                userRole.setUserRoleId(userRoleId);
                UserUtil.insertData(userRole);
                count = userRoleMapper.insertSelective(userRole);
            }


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
    public UserManager selectUserManagerDetail(String userUid) throws Exception {
        return userMapper.selectUserManagerDetail(userUid);
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

        // 新增多角色
        String [] userRoleIds =  userManager.getUserRoleId().split(",");
        for (String userRoleId : userRoleIds) {
            UserRole userRole = new UserRole(
                    UUID.randomUUID().toString(),
                    newUserUid,
                    userRoleId,
                    currentUser.getSs01Id(),
                    now,
                    currentUser.getSs01Id(),
                    now,
                    Delete.UN_DELETE);
            // 新增用户角色表
            count = userRoleMapper.insertSelective(userRole);
        }

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
