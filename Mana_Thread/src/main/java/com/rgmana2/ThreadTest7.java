package com.rgmana2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * @ClassName Thread7
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/5 15:33
 * @Version 1.0
 **/
public class ThreadTest7 {

    public static void main(String[] args) {
        TicketWindow ticketWindow = new TicketWindow(1000);
        List<Thread> list = new ArrayList<>();

        List<Integer> sellCount = new Vector<>();
        for (int i = 0; i < 2000; i++) {
            Thread t = new Thread(() -> {
                int count = ticketWindow.sell(randomAmount());
                try {
                    Thread.sleep(randomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sellCount.add(count);
            });
            list.add(t);
            t.start();
        }

        list.forEach((t) -> {
            try {
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("selled count:" + sellCount.stream().mapToInt(c -> c).sum());
        System.out.println("remainder count:" + ticketWindow.getCount());
    }

    static Random random = new Random();

    public static int randomAmount() {
        return random.nextInt(5) + 1;
    }
}

class TicketWindow {
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int sell(int amount) {
        if (this.count >= amount) {
            this.count -= amount;
            return amount;
        } else {
            return 0;
        }
    }
}
