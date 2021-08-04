package com.rgmana3.callable;

import lombok.SneakyThrows;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName ChloeFutureTask
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 23:59
 * @Version 1.0
 **/
public class ChloeFutureTask<V> implements Runnable {
    ChloeCallable<V> callable;
    Object lock = new Object();
    V result;
    boolean flag = true;
    Thread thread;

    public ChloeFutureTask(ChloeCallable<V> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        result = callable.call();
        //synchronized (lock) {
        //    lock.notify();
        //    flag = false;
        //}
        if(thread != null){
            LockSupport.unpark(thread);
        }
        flag = false;
    }

    @SneakyThrows
    public V get() {
        if (flag) {
            //synchronized (lock) {
            //    lock.wait();
            //}

            thread = Thread.currentThread();
            LockSupport.park(thread);
        }
        return result;
    }


}
