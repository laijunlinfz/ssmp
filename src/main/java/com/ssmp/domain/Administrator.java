package com.ssmp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

// 后台管理员表，仅存储后台管理员

@Data
public class Administrator extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String avatar;
    private String name;
    @TableField(select = false)
    private String password;
    private String token;
    private String phone;
    private String email;
    private Integer type;
//    private Timestamp updateAt;
//    private Timestamp createAt;
}
