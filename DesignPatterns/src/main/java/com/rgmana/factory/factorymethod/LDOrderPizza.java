package com.rgmana.factory.factorymethod;

public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new LDCheesePizza();
        }else if (orderType.equals("greak")){
            pizza = new LDGreekPizza();
        }
        return pizza;
    }
}
