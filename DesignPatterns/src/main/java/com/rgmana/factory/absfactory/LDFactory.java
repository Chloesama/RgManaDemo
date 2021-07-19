package com.rgmana.factory.absfactory;

public class LDFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if(orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        }else if (orderType.equals("greek")){
            pizza = new LDGreekPizza();
        }
        return pizza;
    }
}
