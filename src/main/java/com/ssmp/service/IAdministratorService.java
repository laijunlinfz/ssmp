package com.ssmp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ssmp.domain.Administrator;

import java.util.List;

public interface IAdministratorService extends IService<Administrator> {
    public List<Administrator> getAdministratorOneByParam(Administrator param);
}
