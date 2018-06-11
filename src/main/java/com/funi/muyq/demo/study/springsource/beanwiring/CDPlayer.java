package com.funi.muyq.demo.study.springsource.beanwiring;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/11 09:47]
 */
public class CDPlayer {
    private Disc disc;

    public CDPlayer(Disc disc) {
        this.disc = disc;
    }

    public void play() {
        this.disc.play();
    }
}
