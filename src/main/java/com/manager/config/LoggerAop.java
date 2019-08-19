package com.manager.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 请求参数
 */
@Aspect
@Component
public class LoggerAop {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * controller下的所有@RequestMapping的方法
     */
    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        String uri = request.getRequestURI();

//        // springboot admin的请求不拦截，不然日志太多
//        if (uri.startsWith(request.getContextPath() + "/admin/")
//                || uri.equals(request.getContextPath() + "/error")) {
//            return pjp.proceed(pjp.getArgs());
//        }

        // 打印日志
        long beginTime = System.currentTimeMillis();

        Object result = null;
        try {
            // 执行controller请求
            result = pjp.proceed(pjp.getArgs());
            return result;
        } finally {
            String out = "";
            if (result != null) {
                try {
                    //集合类型转json数组
                    if (result instanceof List || result.getClass().isArray()) {
                        out = JSONArray.toJSONString(result);
                        //对象转json
                    } else {
                        out = JSONObject.toJSONString(result);
                    }
                } catch (JSONException e) {
                    out = result.toString();
                }
            }
            long costMs = System.currentTimeMillis() - beginTime;
            log.info("{}请求结束，result:{}，耗时：{}ms", uri, out, costMs);
        }
    }

}
