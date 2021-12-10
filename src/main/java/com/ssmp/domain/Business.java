package com.ssmp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Business extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer cash;
    private Integer wechat;
    private Integer alipay;
    private Integer total;
    private Integer pay;
    private Integer purchase;
    private Integer surplus;
    private Integer year;
    private Integer month;
    private Integer day;
    private String date;
}
