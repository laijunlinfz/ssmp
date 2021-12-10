package com.ssmp.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ssmp.common.Result;
import com.ssmp.common.ResultCode;
import com.ssmp.domain.Administrator;
import com.ssmp.dto.AuthParam;
import com.ssmp.service.IAdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
public class AdministratorController {

    private IAdministratorService administratorService;

    @Autowired
    public void setAdministratorService (IAdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @RequestMapping("administrator/{id}")
    public Result<Administrator> getAdministratorById(@PathVariable Integer id) {
        return Result.data(administratorService.getById(id));
    }

    @RequestMapping("login")
    public Result<Administrator> login(@RequestBody AuthParam param) {
        String phone = param.getPhone();
        String password = param.getPassword();
        String token = param.getToken();
        Administrator administrator = new Administrator();
        if (StringUtils.isNotBlank(token)) {
            administrator.setToken(token);
        } else if (StringUtils.isNotBlank(phone) && StringUtils.isNotBlank(password)) {
            administrator.setPhone(phone);
            administrator.setPassword(password);
        } else {
            return Result.fail(ResultCode.PARAM_ERR);
        }
        List<Administrator> result = administratorService.getAdministratorOneByParam(administrator);
        if (result.size() == 0) {
            return Result.fail(ResultCode.LOGIN_ERR);
        } else if (result.size() > 1) {
            return Result.fail(ResultCode.FAIL);
        } else {
            Administrator curAdmin = result.get(0);
            StpUtil.login(curAdmin.getId());
            curAdmin.setToken(StpUtil.getTokenValue());
            administratorService.updateById(curAdmin);
            return Result.data(curAdmin);
        }
    }

}
