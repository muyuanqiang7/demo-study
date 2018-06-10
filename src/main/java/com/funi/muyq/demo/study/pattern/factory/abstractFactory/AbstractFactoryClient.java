package com.funi.muyq.demo.study.pattern.factory.abstractFactory;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/4 17:44]
 * 抽象工厂模式 通过抽象工厂模式产品一类产品族 不利于增加产品等级
 */
public class AbstractFactoryClient {

    public static void main(String[] args) {
        HouseholdAppliancesFactory factory = new HairHouseholdAppliancesFactory();
        TV tv = factory.createTV();
        if (tv instanceof HairTV) {
            System.out.println(tv);
        }
    }
}
