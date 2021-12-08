package com.ssmp.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ssmp.utils.R;
import com.ssmp.domain.Administrator;
import com.ssmp.dto.AuthParam;
import com.ssmp.service.IAdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("login")
    public R login(@RequestBody AuthParam param) {
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
            return new R(2, "参数异常");
        }
        List<Administrator> result = administratorService.getAdministratorOneByParam(administrator);
        if (result.size() == 0) {
            return new R(3, "账号名或密码错误");
        } else if (result.size() > 1) {
            return new R(4, "error");
        } else {
            return new R(1, result.get(0));
        }
    }

}
