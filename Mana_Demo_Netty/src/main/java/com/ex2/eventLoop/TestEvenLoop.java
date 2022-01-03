package com.ex2.eventLoop;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestEvenLoop
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/30 22:46
 * @Version 1.0
 **/
public class TestEvenLoop {
    public static void main(String[] args) {
        // 1.创建事件循环组
        // NioEventLoopGroup 能处理 io事件,普通任务,定时任务
        EventLoopGroup group = new NioEventLoopGroup(2);
        // DefaultEventLoopGroup 能处理 普通任务,定时任务
//        EventLoopGroup group = new DefaultEventLoopGroup();

        // 2.获取下一个事件循环对象 第一次 = 第三次
        System.out.println(group.next());
        System.out.println(group.next());
        System.out.println(group.next());

        // 3.执行普通任务
//        group.next().submit(() ->{
//            System.out.println("Scarlet-ok!");
//        });

        // 4.执行定时任务(循环)
        group.next().scheduleAtFixedRate(() -> {
            System.out.println("Scarlet2-ok!");
        }, 0, 1, TimeUnit.SECONDS);

        //只执行一次
        group.next().schedule(() -> {
            System.out.println("Scarlet3-ok!");
        }, 1, TimeUnit.SECONDS);

        System.out.println("main");
    }
}