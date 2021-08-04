package com.rgmana2;

import lombok.SneakyThrows;

/**
 * @ClassName ThreadTest04
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 17:38
 * @Version 1.0
 **/
public class ThreadTest4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + "-Chloe1"));

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-Chloe2");
        }, "t2");
        //Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + "-Chloe2"));
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-Chloe3");
        },"Chloe,t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
