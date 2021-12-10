package com.ssmp.common;

public enum ResultCode implements IResultCode {

    OK(1, "操作成功"),

    FAIL(100, "操作失败"),

    PARAM_ERR(101, "参数异常"),

    CREATE_ERR(101, "新增异常"),

    UPDATE_ERR(102, "更新异常"),

    DEL_ERR(103, "删除异常"),

    READ_ERR(104, "查询异常"),

    LOGIN_ERR(105, "用户名或密码错误"),

    LOGIN_EXPIRED(106, "登录过期"),

    USER_IS_EXIST(107, "用户已存在"),

    ERR(500, "服务异常");

    private final int code;

    private final String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
