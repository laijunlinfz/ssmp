package com.ssmp.utils;

import cn.dev33.satoken.exception.NotLoginException;
import com.ssmp.common.Result;
import com.ssmp.common.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc的异常处理器
@RestControllerAdvice
//@ControllerAdvice
@ResponseBody
public class ProjectExceptionAdvice {
    // token失效
    @ExceptionHandler(NotLoginException.class)
    public Result handleNotLoginException(Exception ex) {
        ex.printStackTrace();
        System.out.println("抛异常了 - 未登录 T_T ExceptionHandler");
        return Result.fail(ResultCode.LOGIN_EXPIRED);
    }

    // 拦截所有异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex) {
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace();
        System.out.println("抛异常了 T_T ExceptionHandler");
        return Result.fail(ResultCode.ERR);
    }
}
