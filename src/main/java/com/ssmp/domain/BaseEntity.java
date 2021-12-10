package com.ssmp.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseEntity {
    private Timestamp updateAt;
    private Timestamp createAt;
}
