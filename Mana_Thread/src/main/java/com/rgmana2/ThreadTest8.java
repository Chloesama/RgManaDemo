package com.rgmana2;

/**
 * @author RgMana
 */
public class ThreadTest8 {
    static final Object obj = new Object();

    public static void m1(){
        synchronized (obj){
            System.out.println("m1");
            m2();
        }
    }

    public static void m2(){
        synchronized (obj){
            System.out.println("m2");
            m3();
        }
    }

    public static void m3(){
        synchronized (obj){
            System.out.println("m3");
        }
    }

    public static void main(String[] args) {
        new Thread(() -> m1()).start();
    }

}
