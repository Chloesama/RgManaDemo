package com.rgmana.factory.simplefactory;

public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给希腊披萨准备原材料");
    }
}
