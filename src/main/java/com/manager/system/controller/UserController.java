package com.manager.system.controller;

import com.manager.entry.common.CommonException;
import com.manager.entry.common.ResultEntry;
import com.manager.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户详情
     * @return
     */
    @RequestMapping("detail")
    @RequiresAuthentication
    public ResultEntry getUserDetail (Principal principal) {
        return ResultUtil.success(principal);
    }
}
