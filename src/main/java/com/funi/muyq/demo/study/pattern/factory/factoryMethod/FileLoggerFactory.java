package com.funi.muyq.demo.study.pattern.factory.factoryMethod;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 20:20]
 */
public class FileLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        return new FileLogger();
    }
}
