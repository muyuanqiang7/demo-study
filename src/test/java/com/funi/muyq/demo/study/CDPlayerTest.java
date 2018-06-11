package com.funi.muyq.demo.study;

import com.funi.muyq.demo.study.springsource.beanwiring.CDPlayer;
import com.funi.muyq.demo.study.springsource.beanwiring.SgtDisc;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/11 09:56]
 */
@ContextConfiguration(locations = {"classpath:config/bean-wiring.xml"})
public class CDPlayerTest extends TestCommon {
    @Resource
    private CDPlayer cdPlayer;
    @Resource
    private SgtDisc sgtDisc;
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void playSong() {
        Assert.assertNotNull(cdPlayer);
        cdPlayer.play();
        Assert.assertEquals("now playing song : 平凡之路, from 后会无期 album\n", systemOutRule.getLog());
    }

    @Test
    public void DiscComposer() {
        sgtDisc.showComposer();
        Assert.assertEquals(2, sgtDisc.getComposer().getOpus().size());
        Assert.assertEquals("Composer(name=朴树, description=中国大陆歌手,音乐人)\n", systemOutRule.getLog());
    }
}
