package com.rgmana.facade;

public class DVDPlayer {
    //使用单例模式

    private static DVDPlayer instance = new DVDPlayer();

    private String name = "DVD";

    private DVDPlayer() {

    }

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(this.name + "on");
    }

    public void off() {
        System.out.println(this.name + " off");
    }

    public void play() {
        System.out.println(this.name + "play");
    }

    public void pause(){
        System.out.println(this.name + " pause");
    }
}
