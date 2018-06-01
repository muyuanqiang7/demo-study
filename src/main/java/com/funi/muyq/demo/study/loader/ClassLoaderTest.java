package com.funi.muyq.demo.study.loader;

import com.google.common.base.Strings;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 14:37]
 */
public class ClassLoaderTest {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader.getParent());
        // System.out.println(classLoader.getParent().getParent().toString()); //nullPointer
        // 基础类型以及基础类型的封装类型、String都是bootStrap ClassLoader加载
        // System.out.println(String.class.getClassLoader().toString()); // nullPointer
        // System.out.println(int.class.getClassLoader().toString()); // nullPointer
        System.out.println("=========================================");
        System.out.println(classLoader.toString());
        System.out.println("=========================================");
        // printClassLoadPath("java.class.path");
        System.out.println("=========================================");
        // printClassLoadPath("sun.boot.class.path");
        System.out.println("=========================================");
        // printClassLoadPath("java.ext.dirs");

        // ResourceClassLoader resourceClassLoader = new ResourceClassLoader("/Users/muyuanqiang/dev");
        ResourceClassLoader resourceClassLoader = new ResourceClassLoader("Person.class");
        System.out.println(resourceClassLoader);
        System.out.println(resourceClassLoader.getParent());
        try {
            Class personClass = resourceClassLoader.loadClass("com.funi.muyq.custom.Person");
            if (personClass != null) {
                Object object = personClass.newInstance();
                Method method = personClass.getDeclaredMethod("execute", String.class);
                method.invoke(object, "ResourceClassLoader load class file");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void printClassLoadPath(String loadProperty) {
        if (Strings.isNullOrEmpty(loadProperty)) {
            return;
        }
        String classPath = System.getProperty(loadProperty);
        if (classPath != null) {
            for (String item : classPath.split(":")) {
                System.out.println(item);
            }
        }

    }
}
