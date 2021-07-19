package com.rgmana.factory.simplefactory;

//简单工厂模式
public class SimpleFactory {
    public Pizza createPizza(String orderType) {
        System.out.println("使用简单工厂模式.");
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }
        return pizza;
    }
}
