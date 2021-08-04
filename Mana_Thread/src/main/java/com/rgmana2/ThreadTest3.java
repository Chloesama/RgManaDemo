package com.rgmana2;

import lombok.SneakyThrows;

/**
 * @ClassName ThreadTest3
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/3 16:50
 * @Version 1.0
 **/
public class ThreadTest3 {
    class Res {
        String username;
        String sex;
        boolean flag = false;
    }

    class InputThread extends Thread {
        Res res;

        public InputThread(Res res) {
            this.res = res;
        }

        @SneakyThrows
        @Override
        public void run() {
            int count = 0;
            while (true) {
                Thread.sleep(1000);
                synchronized (res) {
                    if(res.flag){
                        res.wait();
                    }
                    if (count == 0) {
                        res.username = "Chloe";
                        res.sex = "男";
                    } else {
                        res.username = "RgMana";
                        res.sex = "女";
                    }
                    res.flag = true;
                    res.notify();
                }

                count = (count + 1) % 2;
            }
        }
    }

    class OutputThread extends Thread {
        Res res;

        public OutputThread(Res res) {
            this.res = res;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
                synchronized (res) {
                    if (!res.flag) {
                        res.wait();
                    }
                    System.out.println(res.username + "," + res.sex);
                    res.flag = false;
                    res.notify();
                }
            }
        }
    }

    public void print() {
        Res res = new Res();
        InputThread inputThread = new InputThread(res);
        OutputThread outputThread = new OutputThread(res);
        inputThread.start();
        outputThread.start();
    }

    public static void main(String[] args) {
        ThreadTest3 threadTest3 = new ThreadTest3();
        threadTest3.print();
    }

}
