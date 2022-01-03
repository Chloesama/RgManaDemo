package com.ex2.future;

import java.util.concurrent.*;

/**
 * @ClassName JdkFuture
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/31 13:40
 * @Version 1.0
 **/
public class JdkFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        System.out.println("Scarlet1");
        Future<Integer> future = service.submit(() -> {
            Thread.sleep(1000);
            return 50;
        });

        Integer integer = future.get();
        System.out.println("Scarlet2:" + integer);

    }
}