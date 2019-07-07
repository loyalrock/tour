package com.manager.config;

import com.manager.entry.common.CommonException;
import com.manager.entry.common.ResultEntry;
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
        } else {
            return new ResultEntry("9999", "系统异常！", null);
        }
    }

}
