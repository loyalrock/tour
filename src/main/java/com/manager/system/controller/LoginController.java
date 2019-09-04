package com.manager.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.system.Role;
import com.manager.entry.system.User;
import com.manager.entry.system.UserRole;
import com.manager.system.service.RoleService;
import com.manager.system.service.UserRoleService;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.security.Principal;
import java.util.LinkedHashMap;

/**
 * 描述
 *
 * @auth0r nosign
 * @date 2019/08/16
 */
@RestController
@RequestMapping("/system")
public class LoginController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/login")
    public ResultEntry Login(@RequestParam @NotBlank(message = "用户名不能为空") String username,
                             @RequestParam @NotBlank(message = "密码不能为空") String password)
    {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 登录
        subject.login(token);

        // 获取user对象
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        // 获取角色
        UserRole userRole = userRoleService.selectUserRoleByUserUid(user.getSs01Id());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        jsonObject.put("role", userRole);

        return ResultUtil.success(jsonObject);
    }
}
