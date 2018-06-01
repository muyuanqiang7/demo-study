package com.funi.muyq.demo.study.pattern.factory.simpleFactory;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/1 10:05]
 */
public class CarFactory {
    public static Car createCar(String carType) {
        Car car = null;
        if ("dasCar".equalsIgnoreCase(carType)) {
            car = new DasCar("上海一汽大众", "朗逸");
        } else if ("benCar".equalsIgnoreCase(carType)) {
            car = new BenCar("德国梅赛德斯", "奔驰");
        }
        return car;
    }
}
