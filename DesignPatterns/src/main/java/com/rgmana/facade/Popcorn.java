package com.rgmana.facade;

public class Popcorn {
    //使用单例模式

    private static Popcorn instance = new Popcorn();

    private String name = "popcorn";

    private Popcorn() {

    }

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(this.name + "on");
    }

    public void off() {
        System.out.println(this.name + " off");
    }

    public void pop() {
        System.out.println(this.name + "pop");
    }

}
