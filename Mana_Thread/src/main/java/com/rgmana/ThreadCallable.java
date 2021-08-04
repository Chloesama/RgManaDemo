package com.rgmana;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @ClassName ThreadCallable
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/2 17:10
 * @Version 1.0
 **/
public class ThreadCallable implements Callable {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Chloe1");
        ThreadCallable threadCallable = new ThreadCallable();
        System.out.println("Chloe2");
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(threadCallable);
        System.out.println("Chloe3");
        long l1 = System.currentTimeMillis();
        new Thread(integerFutureTask).start();
        System.out.println("Chloe4");
        Thread.sleep(3000);
        System.out.println(integerFutureTask.get());
        long l2 = System.currentTimeMillis();

        System.out.println("time:" + (l2 - l1));
        System.out.println(l2);
        System.out.println(l1);
    }
}
