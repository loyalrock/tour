package com.manager.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.system.User;
import com.manager.entry.system.UserRole;
import com.manager.system.service.SystemService;
import com.manager.system.service.UserRoleService;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import com.manager.util.Role;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 描述
 *
 * @auth0r nosign
 * @date 2019/08/16
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
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
        List<UserRole> userRoles = userRoleService.selectUserRoleByUserUid(user.getSs01Id());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        jsonObject.put("roles", userRoles);

        return ResultUtil.success(Message.LOGIN_SUCCESS, jsonObject);
    }

    /**
     * 上传文件
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT})
    public ResultEntry upload(@RequestParam("file")MultipartFile multipartFile) throws Exception{
        String url = systemService.upload(multipartFile);
        return ResultUtil.success(Message.INSERT_SUCCESS, url);
    }
}
