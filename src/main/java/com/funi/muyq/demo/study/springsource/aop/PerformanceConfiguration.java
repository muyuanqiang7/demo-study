package com.funi.muyq.demo.study.springsource.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/14 09:35]
 */
@Configuration
@EnableAspectJAutoProxy
public class PerformanceConfiguration {
    @Bean
    public PerformanceServiceImpl performanceService() {
        return new PerformanceServiceImpl();
    }

    @Bean
    public PerformanceAop performanceAop() {
        return new PerformanceAop();
    }
}
