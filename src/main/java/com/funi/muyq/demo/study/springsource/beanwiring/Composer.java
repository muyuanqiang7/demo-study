package com.funi.muyq.demo.study.springsource.beanwiring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/11 10:07]
 */
@Data
@ToString(exclude = "opus")
@AllArgsConstructor()
public class Composer {
    private String name;
    private String description;
    private List<String> opus;
}
