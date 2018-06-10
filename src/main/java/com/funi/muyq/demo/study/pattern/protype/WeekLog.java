package com.funi.muyq.demo.study.pattern.protype;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/5 09:55]
 */
@Data
@Slf4j
public class WeekLog implements Cloneable, Serializable {
    private String name;
    private String Date;
    private String content;

    @Override
    protected WeekLog clone() {
        Object object;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            log.info("clone error: {}", e.getMessage());
            return null;
        }
        return (WeekLog) object;
    }
}
