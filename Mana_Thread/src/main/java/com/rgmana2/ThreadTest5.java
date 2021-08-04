package com.rgmana2;

/**
 * @ClassName ThreadTest5
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 23:03
 * @Version 1.0
 **/
public class ThreadTest5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("主线程结束!!");
    }
}
