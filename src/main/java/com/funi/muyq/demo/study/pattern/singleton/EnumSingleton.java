package com.funi.muyq.demo.study.pattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/5/31 15:48]
 * * 8. 枚举[极推荐使用]
 * *
 * * 这里SingletonEnum.instance
 * * 这里的instance即为SingletonEnum类型的引用所以得到它就可以调用枚举中的方法了。
 * 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
public enum EnumSingleton {
    instance(0);

    private int code;

    EnumSingleton(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public int execute() {
        this.code++;
        return this.code;
    }
}


@Slf4j
class Command implements Runnable {
    private final EnumSingleton enumSingleton;

    public Command(EnumSingleton enumSingleton) {
        this.enumSingleton = enumSingleton;
    }

    public void run() {
        // System.out.println(System.identityHashCode(enumSingleton));
        log.info("{}", enumSingleton.execute());
    }
}

class EnumSingletonTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Command(EnumSingleton.instance));
        }
        executorService.shutdown();
    }
}