package com.funi.muyq.demo.study.pattern.factory.factoryMethod;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 20:19]
 */
public class FileLogger implements Logger {
    public void writeLog(String message) {
        System.out.println(message);
    }
}
