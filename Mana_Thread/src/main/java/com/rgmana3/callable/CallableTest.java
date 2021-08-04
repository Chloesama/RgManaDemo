package com.rgmana3.callable;

import lombok.SneakyThrows;

/**
 * @ClassName CallableTest
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/4 0:02
 * @Version 1.0
 **/
public class CallableTest {
    @SneakyThrows
    public static void main(String[] args) {
        ChloeFutureTask<Integer> chloe1 = new ChloeFutureTask<>(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chloe1");
            return 123;
        });

        new Thread(chloe1).start();

        System.out.println("Chloe3");
        //Thread.sleep(3000);
        System.out.println("Chloe2:" + chloe1.get());

    }
}
