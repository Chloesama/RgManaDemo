package com.rgmana.facade;

public class Screen {
    //使用单例模式

    private static Screen instance = new Screen();

    private String name = "sreen";

    private Screen() {

    }

    public static Screen getInstance() {
        return instance;
    }

    public void up() {
        System.out.println(this.name + "up");
    }

    public void down() {
        System.out.println(this.name + " down");
    }

}
