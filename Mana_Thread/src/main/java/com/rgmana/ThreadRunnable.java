package com.rgmana;

/**
 * @ClassName ThreadRunable
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/2 17:04
 * @Version 1.0
 **/
public class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Chloe!!");
    }

    public static void main(String[] args) {
        new Thread(new ThreadRunnable()).start();
    }
}
