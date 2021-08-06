package com.rgmana2;

/**
 * @ClassName ThreadTest6
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/5 14:38
 * @Version 1.0
 **/
public class ThreadTest6 {
    public static void main(String[] args) {
        T t = new T();
        new Thread(() -> t.a()).start();
        new Thread(() -> t.b()).start();
    }
}

class T {
    public synchronized void a(){
        System.out.println("在a啦");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a");
    }

    public synchronized void b(){
        System.out.println("b");
    }
}
