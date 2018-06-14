package com.funi.muyq.demo.study.springsource.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 09:38]
 */
@Data
@AllArgsConstructor
public class SadSong implements Song {
    private String name;
    private String description;
    private String type;


    public void play() {
        System.out.println(String.format("Now i am %s, so i play %s", this.type, this.name));
    }
}
