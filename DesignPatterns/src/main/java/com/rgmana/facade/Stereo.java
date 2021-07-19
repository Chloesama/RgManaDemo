package com.rgmana.facade;

public class Stereo {
    //使用单例模式

    private static Stereo instance = new Stereo();

    private String name = "sreen";

    private Stereo() {

    }

    public static Stereo getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(this.name + "on");
    }

    public void off() {
        System.out.println(this.name + " off");
    }

    public void up(){
        System.out.println(this.name + "up");
    }

}
