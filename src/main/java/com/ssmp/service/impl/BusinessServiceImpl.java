package com.ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.IBusinessDao;
import com.ssmp.domain.Business;
import com.ssmp.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl extends ServiceImpl<IBusinessDao, Business> implements IBusinessService {
    @Autowired
    private IBusinessDao businessDao;
}
