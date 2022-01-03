package com.ex2.future;

import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName NettyFuture
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/31 13:46
 * @Version 1.0
 **/
public class NettyFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        EventLoop eventLoop = group.next();

        Future<Integer> future = eventLoop.submit(() -> {
            System.out.println("执行计算");
            Thread.sleep(1000);
            return 70;
        });

        // (1)
//        System.out.println("等待结果");
//        System.out.println("结果:" + future.get());

        // (2)
        future.addListener(future1 -> {
            System.out.println("接收结果:" + future1.getNow());
        });

        group.shutdownGracefully();
    }
}