package com.rgmana.factory.factorymethod;

public class LDGreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦的希腊披萨");
        System.out.println("伦敦希腊披萨准备原材料");
    }
}
