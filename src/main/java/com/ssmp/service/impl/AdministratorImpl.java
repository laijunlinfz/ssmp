package com.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.IAdministratorDao;
import com.ssmp.domain.Administrator;
import com.ssmp.service.IAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministratorImpl extends ServiceImpl<IAdministratorDao, Administrator> implements IAdministratorService {
    @Autowired
    IAdministratorDao administratorDao;

    public List<Administrator> getAdministratorOneByParam(Administrator param) {
        QueryWrapper<Administrator> queryWrapper = new QueryWrapper<>(param);
        return administratorDao.selectList(queryWrapper);
    }
}
