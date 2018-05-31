package com.funi.muyq.demo.study.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 1.单例模式的饿汉式[可用]
 * (1)私有化该类的构造函数
 * (2)通过new在本类中创建一个本类对象
 * (3)定义一个公有的方法，将在该类中所创建的对象返回
 * <p>
 * 优点：从它的实现中我们可以看到，这种方式的实现比较简单，在类加载的时候就完成了实例化，避免了线程的同步问题。
 * 缺点：由于在类加载的时候就实例化了，所以没有达到Lazy Loading(懒加载)的效果，也就是说可能我没有用到这个实例，但是它
 * 也
 */
public class HungrySingleton {
    /**
     * 1.单例模式的饿汉式[可用]
     */
    private static HungrySingleton instance = new HungrySingleton();

    /**
     * 私有化构造方法
     */
    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }

    /**
     * 2. 单例模式的饿汉式变换写法[可用]
     * 基本没区别
     */
    private static HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    public static HungrySingleton getHungrySingleton() {
        if (hungrySingleton == null) {
            hungrySingleton = new HungrySingleton();
        }
        return hungrySingleton;
    }
}

@Slf4j
class HungrySingletonTest {
    public static void main(String[] args) {
        log.info("hungrySingleton: {}", HungrySingleton.getHungrySingleton());
        log.info("hungrySingleton: {}", HungrySingleton.getHungrySingleton());
        log.info("hungrySingleton: {}", HungrySingleton.getInstance());
        log.info("hungrySingleton: {}", HungrySingleton.getInstance());
    }
}