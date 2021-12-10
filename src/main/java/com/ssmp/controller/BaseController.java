package com.ssmp.controller;

// TOTO 待完善

import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.common.MyException;
import com.ssmp.common.Result;
import com.ssmp.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

@Slf4j
public abstract class BaseController<S extends IService<T>, T, ID extends Serializable> {
    @Autowired
    protected S service;

    @PostMapping("add")
    public Result<T> save(@RequestBody T entry) {
        try {
            if (service.save(entry) == false) {
                throw new MyException(ResultCode.CREATE_ERR);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new MyException(ResultCode.CREATE_ERR);
        }
        return Result.condition(true);
    }

    @GetMapping("{id}")
    public Result<T> getById(@PathVariable ID id) {
        T res = service.getById(id);
        return Result.data(res);
    }
}
