package com.rgmana.factory.absfactory;

public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if(orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        }else if (orderType.equals("greek")){
            pizza = new BJGreekPizza();
        }
        return pizza;
    }
}
