package com.ssmp.utils;

import cn.dev33.satoken.exception.NotLoginException;
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
    public R doException1(Exception ex) {
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace();
        System.out.println("抛异常了 - 未登录 T_T ExceptionHandler");
        return new R(0, "请先登录");
    }

    // 拦截所有异常
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex) {
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace();
        System.out.println("抛异常了 T_T ExceptionHandler");
        return new R(0, "服务器故障，请稍后再试！");
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public R doException2(Exception ex) {
//        //记录日志
//        //通知运维
//        //通知开发
//        ex.printStackTrace();
//        return new R(0, "服务器故障，请稍后再试11！");
//    }
}
