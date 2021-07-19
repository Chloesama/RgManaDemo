package com.rgmana.factory.absfactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {

    public OrderPizza(AbsFactory absFactory){
        this.setFactory(absFactory);
    }

    private void setFactory(AbsFactory absFactory) {

        Pizza pizza = null;
        String orderType;

        do {
            orderType = this.getType();

            pizza = absFactory.createPizza(orderType);

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

