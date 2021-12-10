package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.domain.Business;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBusinessDao extends BaseMapper<Business> {
}
