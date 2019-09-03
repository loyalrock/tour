package com.manager.system.controller;

import com.manager.entry.common.ResultEntry;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * 描述
 *
 * @auth0r nosign
 * @date 2019/08/16
 */
@RestController
@RequestMapping("/system")
public class LoginController {

    @RequestMapping("/login")
    public ResultEntry Login(@RequestParam @NotBlank(message = "用户名不能为空") String username,
                             @RequestParam @NotBlank(message = "密码不能为空") String password)
    {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            // 用户没有找到
          return ResultUtil.error(Message.NOT_USER_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.success();
    }
}