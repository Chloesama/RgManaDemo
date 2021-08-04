package com.rgmana;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ThreadLock
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 23:13
 * @Version 1.0
 **/
public class ThreadLock {
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ThreadLock threadLock1 = new ThreadLock();

        threadLock1.print();

        Thread.sleep(3000);
        threadLock1.signal();
    }

    public void signal() {
        try {
            lock.lock();
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void print() {

        new Thread(() -> {
            try {
                lock.lock();
                condition.await();
                System.out.println("获取锁成功!");
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }

        }).start();
    }
}
