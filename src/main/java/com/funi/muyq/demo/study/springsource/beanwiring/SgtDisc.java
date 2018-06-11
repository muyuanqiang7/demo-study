package com.funi.muyq.demo.study.springsource.beanwiring;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/11 09:49]
 */
@Data
@Slf4j
public class SgtDisc implements Disc {
    private String name;
    private String albumName;
    private Composer composer;


    public SgtDisc(String name, String albumName) {
        this.name = name;
        this.albumName = albumName;
    }

    public void showComposer(){
        System.out.println(this.composer);
    }

    public void play() {
        // log.info("now playing song : {}, from {} album", this.name, this.albumName);
        System.out.println(String.format("now playing song : %s, from %s album", this.name, this.albumName));
    }
}
