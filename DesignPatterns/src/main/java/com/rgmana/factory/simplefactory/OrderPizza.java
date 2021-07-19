package com.rgmana.factory.simplefactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {

    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory){
        this.setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory){
        String orderType = "";

        this.simpleFactory = simpleFactory;

        do {
            orderType = this.getType();
            pizza = simpleFactory.createPizza(orderType);

            if(pizza != null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("订购披萨失败");
                break;
            }
        }while (true);
    }

//    public OrderPizza(){
//        Pizza pizza = null;
//        String orderType;
//
//        do{
//            orderType = this.getType();
//
//            SimpleFactory simpleFactory = new SimpleFactory();
//            pizza = simpleFactory.createPizza(orderType);
//
//            if(pizza != null){
//                pizza.prepare();
//                pizza.bake();
//                pizza.cut();
//                pizza.box();
//            }else{
//                break;
//            }
//        }while (true);
//    }

    private String getType(){
        try {
            BufferedReader strn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strn.readLine();
            return str;
        }catch (Exception e){
            return null;
        }
    }
}
