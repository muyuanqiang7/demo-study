package com.funi.muyq.demo.study.springsource.aop;

import java.lang.annotation.*;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/14 09:44]
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PerformanceAnnotation {
    String value() default "";
}
