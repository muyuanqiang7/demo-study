package com.funi.muyq.demo.study.springsource.aop;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/14 09:23]
 */
public class PerformanceServiceImpl implements PerformanceService {
    @PerformanceAnnotation(value = "perform")
    public void perform() {
        System.out.println("perform start......");
    }
}
