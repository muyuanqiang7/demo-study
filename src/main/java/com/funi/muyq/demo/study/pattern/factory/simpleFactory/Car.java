package com.funi.muyq.demo.study.pattern.factory.simpleFactory;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/5/31 17:54]
 *
 */
public abstract class Car {
    protected String factory;
    protected String brand;

    public Car(String factory, String brand) {
        this.factory = factory;
        this.brand = brand;
        this.create();
    }

    protected void create() {
        System.out.println(this.getClass().getSimpleName() + " Create, Factory:" + this.factory);
    }

    /**
     * 简单工厂模式的简化
     * 将抽象产品类和工厂类合并,将静态方法移到抽象产品类中
     *
     * @param carType
     * @return
     */
    public static Car createCar(String carType) {
        Car car = null;
        if ("dasCar".equalsIgnoreCase(carType)) {
            car = new DasCar("上海一汽大众", "朗逸");
        } else if ("benCar".equalsIgnoreCase(carType)) {
            car = new BenCar("德国梅赛德斯", "奔驰");
        }
        return car;
    }

    public abstract Car drive();

}
