package com.manager.shiro;

import com.manager.entry.system.Role;
import com.manager.entry.system.User;
import com.manager.entry.system.UserRole;
import com.manager.system.service.RoleService;
import com.manager.system.service.UserRoleService;
import com.manager.system.service.UserService;
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
    private UserRoleService userRoleService;

    private static Map<String, List<String>> USER_ROLE_CACHE = new ConcurrentHashMap<>();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 获取用户角色
        String ss01Id = user.getSs01Id();
        List<String> roles = USER_ROLE_CACHE.get(ss01Id);

        if (roles == null) {
            // 缓存并设置角色
            List<UserRole> userRoles = userRoleService.selectUserRoleByUserUid(user.getSs01Id());
            roles = new ArrayList<>();
            for (UserRole userRole : userRoles) {
                roles.add(userRole.getUserRoleId());
            }
            USER_ROLE_CACHE.put(ss01Id, roles);
            info.addRoles(roles);
        } else {
            info.addRoles(roles);
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        User user = userService.selectUserByUserId(username);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }
        if (User.DISABLE.equals(user.getStatus())) {
            // 用户被管理员锁定抛出异常
            throw new LockedAccountException();
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
