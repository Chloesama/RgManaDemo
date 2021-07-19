package com.rgmana.decorator;

public class CofferBar {
    public static void main(String[] args) {

        //1.点一份LongBlack
        Drink order = new LongBlack();

        System.out.println("费用1=" + order.cost());
        System.out.println("描述=" + order.getDes());

        //2.加入一份牛奶
        order = new Milk(order);

        System.out.println("费用2=" + order.cost());
        System.out.println("描述2=" + order.getDes());

        //3.加入一份巧克力
        order = new Chocolate(order);

        System.out.println("费用3=" + order.cost());
        System.out.println("描述3=" + order.getDes());

        //4.加入一份巧克力
        order = new Chocolate(order);

        System.out.println("费用4=" + order.cost());
        System.out.println("描述4=" + order.getDes());

    }
}
