package com.funi.muyq.demo.study;

import com.funi.muyq.demo.study.springsource.aop.PerformanceConfiguration;
import com.funi.muyq.demo.study.springsource.aop.PerformanceService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/14 09:36]
 */
@ContextConfiguration(classes = {PerformanceConfiguration.class})
public class AopTest extends TestCommon {
    @Resource
    private PerformanceService performanceService;
    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void test() {
        performanceService.perform();
        // Assert.assertEquals("Performance start...please make your phone silence\nperform start......\n", systemOutRule.getLog());
    }
}
