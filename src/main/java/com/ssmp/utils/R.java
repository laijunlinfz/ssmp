package com.ssmp.utils;

import lombok.Data;

// API 返回数据结构
@Data
public class R {
    private Integer code;
    private Object data;
    private String msg;

    public R(){}

    public R(Integer code){
        this.code = code;
        this.data = null;
        this.msg = code.equals(1) ? "success" : "fail";
    }

    public R(Integer code, Object data){
        this.code = code;
        this.data = data;
        this.msg = code.equals(1) ? "success" : "fail";
    }

    public R(Integer code, String msg){
        this.code = code;
        this.data = null;
        this.msg = msg;
    }

    public R(String msg){
        this.code = 1;
        this.data = null;
        this.msg = msg;
    }
}
