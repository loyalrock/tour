package com.manager.shiro;

import com.manager.entry.common.CommonException;
import com.manager.entry.system.User;
import com.manager.entry.system.UserProject;
import com.manager.entry.system.UserRole;
import com.manager.system.dao.UserProjectMapper;
import com.manager.system.service.RoleService;
import com.manager.system.service.UserRoleService;
import com.manager.system.service.UserService;
import com.manager.util.Environment;
import com.manager.util.Message;
import com.manager.util.Role;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProjectMapper userProjectMapper;

    @Autowired
    private UserRoleService userRoleService;

    public static Map<String, String> USER_ROLE_CACHE = new ConcurrentHashMap<>();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 获取用户角色
        String ss01Id = user.getSs01Id();
        String role = USER_ROLE_CACHE.get(ss01Id);

//        if (roles == null) {
//            // 缓存并设置角色
//            List<UserRole> userRoles = userRoleService.selectUserRoleByUserUid(user.getSs01Id());
//            roles = new ArrayList<>();
//            for (UserRole userRole : userRoles) {
//                roles.add(userRole.getUserRoleId());
//            }
//            USER_ROLE_CACHE.put(ss01Id, roles);
//            info.addRoles(roles);
//        } else {
        info.addRole(role);
//        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        // 登录环境
        String type = token.getHost();

        User user = userService.selectUserByUserId(username);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new CommonException(Message.NOT_USER_FOUND);
        }
        if (User.DISABLE.equals(user.getStatus())) {
            // 用户被管理员锁定抛出异常
            throw new CommonException(Message.DISABLE_USER);
        }
        if (!user.getPassword().equals(password)) {
            throw new CommonException(Message.PASSWORD_ERROR);
        }

        UserRole userRole = userRoleService.selectUserRoleByUserUid(user.getSs01Id());
        String userRoleId = userRole.getUserRoleId();
        USER_ROLE_CACHE.put(user.getSs01Id(), userRoleId);

        // 专家只能登前台
        if (type.equals(Environment.SERVER) && userRoleId.equals(Role.EXPERTS)) {
            throw new CommonException(Message.LOGIN_TYPE_ERROR);
        }

        // 非全域 放入项目
        if (!userRoleId.equals(Role.SYSTEM)) {
            UserProject userProject = userProjectMapper.selectProjectBySs01Id(user.getSs01Id());
            if (userProject == null || userProject.getProjectNo() == null || "".equals(userProject.getProjectNo().trim())) {
                throw new CommonException(Message.PROJECT_DISABLE);
            }
            user.setUserProject(userProject);
        }

        user.setUserRole(userRole);

        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
