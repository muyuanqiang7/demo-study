package com.funi.muyq.demo.study.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/5/31 15:39]
 * 内部类[推荐用]
 * * <p>
 * * 这种方式跟饿汉式方式采用的机制类似，但又有不同。
 * * 两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
 * * 不同的地方:
 * * 在饿汉式方式是只要Singleton类被装载就会实例化,
 * * 内部类是在需要实例化时，调用getInstance方法，才会装载SingletonHolder类
 * * <p>
 * * 优点：避免了线程不安全，延迟加载，效率高。
 */
public class InnerClassSingleton {
    private static class InnerClassSingletonHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassSingletonHolder.instance;
    }
}

@Slf4j
class InnerClassSingletonTest {
    public static void main(String[] args) {
        log.info("innerClassSingleton: {}", InnerClassSingleton.getInstance());
        log.info("innerClassSingleton: {}", InnerClassSingleton.getInstance());
    }
}