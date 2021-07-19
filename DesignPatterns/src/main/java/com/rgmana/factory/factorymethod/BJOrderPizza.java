package com.rgmana.factory.factorymethod;

public class BJOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")){
            pizza = new BJCheesePizza();
        }else if (orderType.equals("greak")){
            pizza = new BJGreekPizza();
        }
        return pizza;
    }
}
