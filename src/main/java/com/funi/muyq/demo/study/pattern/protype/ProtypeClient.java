package com.funi.muyq.demo.study.pattern.protype;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/5 09:59]
 */
@Slf4j
public class ProtypeClient {
    public static void main(String[] args) {
        WeekLog weekLog = new WeekLog();
        weekLog.setName("muyuanqiang");
        weekLog.setDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        weekLog.setContent("nothing to say");
        WeekLog cloneWeekLog = weekLog.clone();
        log.info("{}", weekLog == cloneWeekLog);
        log.info("{}", weekLog.getDate() == cloneWeekLog.getDate());
        log.info("{}", weekLog.getDate());
    }
}
