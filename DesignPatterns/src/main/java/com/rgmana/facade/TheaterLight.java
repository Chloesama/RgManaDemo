package com.rgmana.facade;

public class TheaterLight {
    //使用单例模式

    private static TheaterLight instance = new TheaterLight();

    private String name = "theaterLight";

    private TheaterLight() {

    }

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(this.name + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    public void off() {
        System.out.println(this.name + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    public void dim(){
        System.out.println(this.name + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

    public void bright(){
        System.out.println(this.name + Thread.currentThread() .getStackTrace()[1].getMethodName());
    }

}
