package com.manager.config;

import com.manager.entry.common.CommonException;
import com.manager.entry.common.ResultEntry;
import com.manager.util.Message;
import com.manager.util.ResultUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.function.Consumer;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 实体中参数校验失败
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultEntry validExceptionHandler(MethodArgumentNotValidException e, HttpServletResponse response) {
        StringBuffer errorMessage = new StringBuffer();
        e.getBindingResult().getAllErrors().forEach(error -> {
            errorMessage.append(error.getDefaultMessage());
        });
        return ResultUtil.error(errorMessage.toString());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultEntry exceptionHandler(Exception e, HttpServletResponse response) {
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            return ResultUtil.error(commonException.getMessageEnum());
        } else if (e instanceof AuthenticationException) {
            // 未登录
            AuthenticationException authenticationException = (AuthenticationException) e;
            Throwable throwable = e.getCause();
            if (throwable instanceof CommonException) {
                return ResultUtil.error(((CommonException) throwable).getMessageEnum());
            } else if (e instanceof IncorrectCredentialsException) {
                // 密码错误
                return ResultUtil.error(Message.PASSWORD_ERROR);
            } else {
                return ResultUtil.error(e.getMessage());
            }

        } else if (e instanceof UnauthorizedException) {
            // 没有权限
            return ResultUtil.error(Message.NO_PERMISSIONS);
        } else {
            e.printStackTrace();
            return new ResultEntry("9999", "系统异常！", null);
        }
    }

}
