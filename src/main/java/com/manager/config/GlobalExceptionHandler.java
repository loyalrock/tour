package com.manager.config;

import com.manager.entry.common.CommonException;
import com.manager.entry.common.ResultEntry;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultEntry exceptionHandler(Exception e, HttpServletResponse response) {
        e.printStackTrace();
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            ResultEntry resultEntry = new ResultEntry(e.getMessage());
            return resultEntry;
        } else if (e instanceof UnauthenticatedException) {
            // 未登录
            return ResultUtil.error(Message.NEED_LOGIN);
        } else if (e instanceof IncorrectCredentialsException) {
            // 密码错误
            return ResultUtil.error(Message.PASSWORD_ERROR);
        } else if (e instanceof LockedAccountException) {
            // 用户禁用
            return ResultUtil.error(Message.DISABLE_USER);
        } else if (e instanceof UnknownAccountException) {
            // 没有找到用户
            return ResultUtil.error(Message.NOT_USER_FOUND);
        } else if (e instanceof UnauthorizedException) {
            // 没有权限
            return ResultUtil.error(Message.NO_PERMISSIONS);
        } else {
            return new ResultEntry("9999", "系统异常！", null);
        }
    }

}
