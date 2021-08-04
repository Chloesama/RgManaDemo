package com.rgmana;

/**
 * @ClassName Thread01
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/2 16:57
 * @Version 1.0
 **/
public class Thread01 extends Thread {

    @Override
    public void run() {
        System.out.println("Chloe-Thread01");
    }

    public static void main(String[] args) {
        new Thread01().start();
    }
}
