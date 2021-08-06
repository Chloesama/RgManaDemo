package com.rgmana2;

import lombok.SneakyThrows;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TwoPhaseTermination
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/4 18:39
 * @Version 1.0
 **/
public class TwoPhaseTermination {

    private Thread monitor;

    @SneakyThrows
    public static void main(String[] args) {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();
        Thread.sleep(3500);
        twoPhaseTermination.stop();
    }

    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread thread = Thread.currentThread();
                if (thread.isInterrupted()) {
                    System.out.println("线程退出!!!");
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("执行监控记录.");
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    thread.interrupt();
                }
            }
        });

        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}
