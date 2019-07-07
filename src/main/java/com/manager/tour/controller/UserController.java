package com.manager.tour.controller;

import com.manager.entry.common.CommonException;
import com.manager.entry.common.ResultEntry;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public ResultEntry login(@RequestParam String username, @RequestParam String password) throws CommonException {
        username = username.trim();
        password = password.trim();
        if (username == null || "".equals(username)) {
            throw new CommonException("用户名不能为空！");
        }
        if (password == null || "".equals(password)) {
            throw new CommonException("密码不能为空！");
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);

        return new ResultEntry("登陆成功！");
    }
}
