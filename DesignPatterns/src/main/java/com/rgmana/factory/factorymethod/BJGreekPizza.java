package com.rgmana.factory.factorymethod;

public class BJGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的希腊披萨");
        System.out.println("北京希腊披萨准备原材料");
    }
}
