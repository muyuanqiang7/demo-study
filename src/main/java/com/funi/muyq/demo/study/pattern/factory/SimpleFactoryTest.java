package com.funi.muyq.demo.study.pattern.factory;

import com.funi.muyq.demo.study.pattern.factory.simpleFactory.Car;
import com.funi.muyq.demo.study.pattern.factory.simpleFactory.CarFactory;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/5/31 17:52]
 * 简单工厂模式
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CarFactory.createCar(XMLUtil.getCarType()).drive();
        Car.createCar(XMLUtil.getCarType()).drive();
    }
}

