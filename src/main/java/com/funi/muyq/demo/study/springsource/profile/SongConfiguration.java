package com.funi.muyq.demo.study.springsource.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 09:40]
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
public class SongConfiguration {

    @Resource
    private Environment environment;

    @Value(value = "${className}")
    private String message;

    @Bean
    @Profile("sad")
    public SadSong sadSong() {
        return new SadSong("我终于失去了你", "李宗盛", "sad");
    }

    @Bean
    @Profile("happy")
    public HappySong happySong() {
        return new HappySong("春天在哪里", "佚名", "happy");
    }

    @Bean
    @Conditional(value = MagicExistCondition.class)
    public Magic magic() {
        System.out.println(environment.getProperty("spring.profile.active"));
        return new Magic(message);
    }
}
