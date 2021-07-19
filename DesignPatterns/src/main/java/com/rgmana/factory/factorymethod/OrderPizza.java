package com.rgmana.factory.factorymethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class OrderPizza {

    abstract Pizza createPizza(String orderType);

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;

        do {
            orderType = this.getType();
            pizza = createPizza(orderType);

            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                break;
            }
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader strn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strn.readLine();
            return str;
        } catch (Exception e) {
            return null;
        }
    }
}

