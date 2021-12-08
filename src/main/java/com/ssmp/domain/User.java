package com.ssmp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

// 用户表，仅存储微信用户
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
}
