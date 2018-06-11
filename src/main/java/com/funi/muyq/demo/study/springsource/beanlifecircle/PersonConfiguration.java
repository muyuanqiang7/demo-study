package com.funi.muyq.demo.study.springsource.beanlifecircle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/8 11:12]
 */
@Configuration
public class PersonConfiguration {
    @Bean
    public Home home() {
        return new Home();
    }

    @Bean
    public InitPerson initPerson() {
        return new InitPerson();
    }

    @Bean
    public Person asianPerson() {
        return new Person("","");
    }
}
