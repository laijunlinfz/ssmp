package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.domain.Administrator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAdministratorDao extends BaseMapper<Administrator> {
}
