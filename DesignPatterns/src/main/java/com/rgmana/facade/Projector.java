package com.rgmana.facade;

public class Projector {
    //使用单例模式

    private static Projector instance = new Projector();

    private String name = "projector";

    private Projector() {

    }

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(this.name + "on");
    }

    public void off() {
        System.out.println(this.name + " off");
    }

    public void focus() {
        System.out.println(this.name + " focus");
    }

}
