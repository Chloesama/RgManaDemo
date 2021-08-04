package com.rgmana;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName Executor
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/2 17:33
 * @Version 1.0
 **/
public class Executor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(
            () -> {
            // ... do something inside runnable task
            
        });
        service.shutdown();
    }
}
