package com.funi.muyq.demo.study.pattern.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 20:22]
 */
public class PropertisUtil {
    private static Properties properties;

    static {
        InputStream inputStream = PropertisUtil.class.getClassLoader().getResourceAsStream("application.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException ignored) {
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }
}
