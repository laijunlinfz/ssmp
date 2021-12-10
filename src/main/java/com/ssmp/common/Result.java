package com.ssmp.common;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
public class Result<T> implements Serializable {
    private Integer code;
    private T data;
    private String msg;
    private String time;

    private Result() {
        this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date());//设置日期格式;
    }

    private Result(IResultCode resultCode) {
        this(resultCode.getCode(), null, resultCode.getMsg());
    }

    private Result(IResultCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private Result(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMsg());
    }

    private Result(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private Result(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date());
    }

    /**
     * 返回状态码
     *
     * @param resultCode 状态码
     * @param <T>        泛型标识
     * @return ApiResult
     */
    public static <T> Result<T> ok(IResultCode resultCode) {
        return new Result<>(resultCode);
    }

    public static <T> Result<T> ok(String msg) {
        return new Result<>(ResultCode.OK, msg);
    }

    public static <T> Result<T> ok(IResultCode resultCode, String msg) {
        return new Result<>(resultCode, msg);
    }

    public static <T> Result<T> data(T data) {
        return data(data, ResultCode.OK.getMsg());
    }

    public static <T> Result<T> data(T data, String msg) {
        return data(ResultCode.OK.getCode(), data, msg);
    }

    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result<>(code, data, msg);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(ResultCode.FAIL.getCode(), null, ResultCode.FAIL.getMsg());
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<>(ResultCode.FAIL.getCode(), null, msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, null, msg);
    }

    public static <T> Result<T> fail(IResultCode resultCode) {
        return new Result<>(ResultCode.FAIL.getCode(), null, ResultCode.FAIL.getMsg());
    }

    public static <T> Result<T> fail(IResultCode resultCode, String msg) {
        return new Result<>(resultCode, null, msg);
    }

    public static <T> Result<T> condition(boolean flag) {
        return flag ? ok(ResultCode.OK) : fail(ResultCode.FAIL);
    }
}
