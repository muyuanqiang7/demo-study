package com.funi.muyq.demo.study.springsource.beanlifecircle;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/8 11:08]
 * 1.spring容器实例化对象
 * 2.spring容易设置bean的属性
 * 3.如果bean 实现了BeanNameAware接口则将beanId传递给setBeanName方法设置beanName
 * 4.如果bean实现了BeanFactoryAware接口则调用setBeanFactory方法设置beanFactory
 * 5.如果bean实现了ApplicationContextAware接口则调用setApplicationContext方法将bean所在应用上下文传递给该方法
 * beanPostProcess接口则调用postProcessBeforeInitialization方法 前置和后置方法为自定义bean非常有用
 * 7.如果bean实现了InitializationBean接口调用afterPropertySet或者指定了init-method也会调用该方法
 * beanPostProcess接口则调用postProcessBeforeInitialization方法
 * 9.bean被创建好可以被使用会一直存在于应用中直到应用被销毁
 * 10.bean是否实现了DisposableBean接口调用destroy方法或者指定了destroy-method
 */
@Slf4j
@Data
@ToString
public class Person implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
    @Autowired
    private Home home;
    private String name;
    private String address;


    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info(beanFactory.toString());
    }

    public void setBeanName(String s) {
        log.info(s);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info(applicationContext.getApplicationName());
        log.info(applicationContext.getDisplayName());
        log.info(applicationContext.getId());
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void afterPropertiesSet() throws Exception {

    }

    public void destroy() {
        log.info("Person bean destroy");
    }
}
