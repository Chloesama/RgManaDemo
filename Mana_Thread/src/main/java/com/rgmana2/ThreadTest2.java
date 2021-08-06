package com.rgmana2;

import lombok.SneakyThrows;

/**
 * @ClassName ThreadTest2
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 16:45
 * @Version 1.0
 **/
public class ThreadTest2 {
    String lock = "lock";

    public static void main(String[] args) throws InterruptedException {
        new ThreadTest2().test();
    }

    public void test() throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "---" + "test1!");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "---" + "test2!");
            }
        }).start();

        Thread.sleep(3000);

        synchronized (lock) {
            lock.notify();
        }
    }
}
