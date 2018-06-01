package com.funi.muyq.demo.study.pattern.factory.simpleFactory;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 09:48]
 */
public class BenCar extends Car {
    public BenCar(String factory, String brand) {
        super(factory, brand);
    }

    public Car drive() {
        System.out.println("Drive " + this.getClass().getSimpleName() + " Create, Factory:" + this.factory);
        return this;
    }
}
