package com.funi.muyq.demo.study.springsource.beanlifecircle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.Resource;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/8 13:52]
 */
@Slf4j
public class InitPerson implements BeanPostProcessor {
    @Resource
    private Home home;

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        log.info("postProcessBeforeInitialization bean name: {}", s);
        if (o instanceof Person) {
            Person person = (Person) o;
            person.setName("BeanNameAware");
            person.setAddress("BeanNameAware");
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        log.info(home.toString());
        log.info("postProcessAfterInitialization bean name: {}", s);
        return o;
    }
}
