package com.funi.muyq.demo.study.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: [com.funi.muyq.demo.study.pattern.singletonSingleton]
 * @Description: [懒汉模式 instance 延迟实例化]
 * @Author: [yuanqiang.mou@funi365.com]
 * @CreateDate: [2018/5/31 13:24]
 * @UpdateUser: []
 * @UpdateDate: []
 * @UpdateRemark: []
 * @Version: [v1.0]
 * * 1.单例模式的懒汉式[不可可用]
 * * (1)私有化该类的构造函数
 * * (2)定义一个公有的方法，将在该类中所创建的对象返回 如果为null 则new创建
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    /**
     * 1.单例模式的懒汉式[线程不安全，不可用]
     *
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) { //线程不安全, 可能得到两个不同的实例
            instance = new LazySingleton();
        }
        return instance;
    }

    public void execute() {
        System.out.println(LazySingleton.instance);
    }

    private static LazySingleton lazySingleton;

    /**
     * * 2. 懒汉式线程安全的:[线程安全，效率低不推荐使用]
     * * <p>
     * * 缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
     * * 而其实这个方法只执行一次实例化代码就够了，
     * * 后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
     *
     * @return
     */
    public synchronized static LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    private static LazySingleton singleton;

    /**
     * 3. 单例模式懒汉式[线程不安全，不可用]
     * * <p>
     * * 虽然加了锁，但是等到第一个线程执行完instance=new Singleton()跳出这个锁时，
     * * 另一个进入if语句的线程同样会实例化另外一个Singleton对象，线程不安全的原理跟1类似。
     *
     * @return
     */
    public static LazySingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                singleton = new LazySingleton();
            }
        }
        return singleton;
    }

    private static LazySingleton lazySingletonDcl;

    /**
     * 4.单例模式懒汉式双重校验锁[推荐用]
     * 懒汉式变种,属于懒汉式的最好写法,保证了:延迟加载和线程安全
     */
    public static LazySingleton getLazySingletonDcl() {
        if (lazySingletonDcl == null) {
            synchronized (LazySingleton.class) {
                if (lazySingletonDcl == null) {
                    lazySingletonDcl = new LazySingleton();
                }
            }
        }
        return lazySingletonDcl;
    }
}

@Slf4j
class SingletonCommand implements Runnable {
    public void run() {
        LazySingleton singleton = LazySingleton.getInstance();

        log.info("instance info: {}", singleton);
    }
}

@Slf4j
class SingletonForLazyTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new SingletonCommand());
        }
        executorService.shutdown();
        // LazySingleton singleton = LazySingleton.getInstance();
        // log.info("instance info: {}", singleton);
        // log.info("instance packageName: {}", singleton.getClass().getPackage().getName());
        // log.info("instance className: {}", singleton.getClass().getName());
        // log.info("instance className: {}", singleton.getClass().getSimpleName());
    }
}
