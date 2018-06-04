package com.funi.muyq.demo.study.pattern.factory.factoryMethod;

import com.funi.muyq.demo.study.pattern.factory.PropertisUtil;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 20:21]
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = PropertisUtil.getValue("className");
        Class targetClass = Class.forName(className);
        LoggerFactory loggerFactory = (LoggerFactory) targetClass.newInstance();
        loggerFactory.createLogger().writeLog(loggerFactory.getClass().getSimpleName());
    }
}
