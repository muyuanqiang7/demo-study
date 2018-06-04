package com.funi.muyq.demo.study.pattern.factory.factoryMethod.practice;

import lombok.Data;

import java.util.Date;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 20:50]
 */
@Data
public abstract class Picture {
    private String path;
    private String name;
    private int size;
    private Date createDate;
    private Date updateDate;
    private String type;
}
