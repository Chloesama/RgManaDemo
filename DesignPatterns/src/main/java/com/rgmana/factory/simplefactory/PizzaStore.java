package com.rgmana.factory.simplefactory;


//简单工厂模式
public class PizzaStore {
    public static void main(String[] args) {

        new OrderPizza(new SimpleFactory());
    }
}
