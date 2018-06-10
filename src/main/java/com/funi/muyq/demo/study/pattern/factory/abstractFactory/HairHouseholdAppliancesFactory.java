package com.funi.muyq.demo.study.pattern.factory.abstractFactory;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/5 09:27]
 */
public class HairHouseholdAppliancesFactory implements HouseholdAppliancesFactory {
    public TV createTV() {
        TV hairTv = new HairTV();
        hairTv.setFactory("海尔电器");
        hairTv.setFactoryAddress("青岛海尔电器");
        return hairTv;
    }

    public Fridge createFridge() {
        return new HairFridge();
    }
}
