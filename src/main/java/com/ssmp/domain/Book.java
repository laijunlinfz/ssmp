package com.ssmp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Book {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String description;
}
