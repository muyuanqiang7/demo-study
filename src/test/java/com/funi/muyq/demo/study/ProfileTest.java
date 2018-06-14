package com.funi.muyq.demo.study;

import com.funi.muyq.demo.study.springsource.profile.Magic;
import com.funi.muyq.demo.study.springsource.profile.Song;
import com.funi.muyq.demo.study.springsource.profile.SongConfiguration;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 09:44]
 */
@ActiveProfiles("sad")
@ContextConfiguration(classes = {SongConfiguration.class})
// @ContextConfiguration(locations = {"classpath:config/spring-profile.xml"})
public class ProfileTest extends TestCommon {

    @Resource
    private Song song;
    @Resource
    private ApplicationContext applicationContext;
    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void test() {
        Assert.assertNotNull(song);
        song.play();
        Assert.assertEquals("Now i am sad, so i play 我终于失去了你\n", systemOutRule.getLog());
    }

    @Test
    public void testConditional() {
        Magic magic = applicationContext.getBean("magic", Magic.class);
        Assert.assertNotNull(magic);
        System.out.println(magic.getMessage());
    }
}
