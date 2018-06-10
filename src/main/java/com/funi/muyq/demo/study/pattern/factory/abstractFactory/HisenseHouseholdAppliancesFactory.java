package com.funi.muyq.demo.study.pattern.factory.abstractFactory;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/5 09:32]
 */
public class HisenseHouseholdAppliancesFactory implements HouseholdAppliancesFactory {
    public TV createTV() {
        return new HisenseTV();
    }

    public Fridge createFridge() {
        return new HisenseFridge();
    }
}
