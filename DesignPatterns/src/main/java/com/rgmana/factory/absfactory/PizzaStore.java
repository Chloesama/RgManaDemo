package com.rgmana.factory.absfactory;


//工厂方法模式
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
