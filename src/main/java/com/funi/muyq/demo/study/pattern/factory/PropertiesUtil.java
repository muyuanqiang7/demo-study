package com.funi.muyq.demo.study.pattern.factory;

import com.google.common.base.Strings;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 20:22]
 */
public class PropertiesUtil {
    private static Properties properties;
    private static final HashMap<String, String> propertyMap = new HashMap<String, String>();

    static {
        InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException ignored) {
        }
    }

    public static String getString(String key) {
        String value = propertyMap.get(key);
        if (Strings.isNullOrEmpty(value)) {
            String tempValue = properties.getProperty(key);
            propertyMap.put(key, tempValue);
            return tempValue;
        }
        return value;
    }

    public static int getInt(String key) {
        String value = propertyMap.get(key);
        if (Strings.isNullOrEmpty(value)) {
            String tempValue = properties.getProperty(key);
            propertyMap.put(key, tempValue);
            return Integer.valueOf(tempValue);
        }
        return Integer.valueOf(value);
    }

    public static boolean getBoolean(String key) {
        String value = propertyMap.get(key);
        if (Strings.isNullOrEmpty(value)) {
            String tempValue = properties.getProperty(key);
            propertyMap.put(key, tempValue);
            return Boolean.valueOf(tempValue);
        }
        return Boolean.valueOf(value);
    }
}
