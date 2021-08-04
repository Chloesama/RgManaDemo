package com.rgmana2;

import lombok.SneakyThrows;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 15:41
 * @Version 1.0
 **/
public class ThreadTest implements Runnable{

    private static int n = 100;

    private static Object lock = new Object();

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            Thread.sleep(30);


                /**
                 * this对象锁(this锁) -- 只能用于同一个对象
                 */
                //synchronized (this){
                //    this.sub();
                //}

                /**
                 * object对象锁
                 */
                //synchronized (lock){
                //    this.sub();
                //}

                this.sub();
        }
    }

    /**
     * 如果把synchronized加在示例方法上,则使用this锁
     */
    public synchronized void sub(){
        if(n > 1){
            n--;
            System.out.println(Thread.currentThread().getName() + "---" + n);
        }
    }

    //public void sub(){
    //    if(n > 1){
    //        n--;
    //        System.out.println(Thread.currentThread().getName() + "---" + n);
    //    }
    //}

    public static void main(String[] args) {
        //ThreadTest threadTest = new ThreadTest();
        //new Thread(threadTest).start();
        //new Thread(threadTest).start();

        ThreadTest threadTest1 = new ThreadTest();
        ThreadTest threadTest2 = new ThreadTest();
        new Thread(threadTest1).start();
        new Thread(threadTest2).start();

    }
}
