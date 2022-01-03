package com.ex2.eventLoop;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @ClassName HelloClient
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/30 22:01
 * @Version 1.0
 **/
public class EventClient {
    public static void main(String[] args) throws InterruptedException {
        /*
        // 1.启动类
        Channel channel = new Bootstrap()
                // 2.添加EventLoop
                .group(new NioEventLoopGroup())
                // 3.选择客户端channel实现
                .channel(NioSocketChannel.class)
                // 4.添加处理器 ChannelInitializer在连接成功后调用
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                // 5.连接到服务器
                .connect(new InetSocketAddress("127.0.0.1", 9999))
                // 阻塞方法,直接连接建立
                .sync()
                .channel();

        channel.writeAndFlush("Scarlet1");
        Thread.sleep(1000);
        channel.writeAndFlush("Scarlet2");

        channel.close();
         */

        NioEventLoopGroup group = new NioEventLoopGroup();
        //带有future Promise都是配合异步方法来调用的
        ChannelFuture channelFuture = new Bootstrap()
                // 2.添加EventLoop
                .group(group)
                // 3.选择客户端channel实现
                .channel(NioSocketChannel.class)
                // 4.添加处理器 ChannelInitializer在连接成功后调用
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                // 5.连接到服务器
                // 异步非阻塞,main发起的调用 处理执行connect是nio线程  这个得要有个时间差,可能1s左右
                .connect(new InetSocketAddress("127.0.0.1", 9999));

        // 处理方法1
        // 使用sync方法来同步处理结果
        // 在调用sync的时候会阻塞
        channelFuture.sync();
        // 如果上面不用sync的话,在connect连接之前,就会执行这里的代码,那就会导致channel是没有连接上服务器的,导致,数据发送不成功
        Channel channel = channelFuture.channel();
//        channel.writeAndFlush("Scarlet!!!");

        new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            while (true) {
                String msg = sc.nextLine();
                if (StringUtils.equals("q", msg)) {
                    //这个close也是个异步方法
                    channel.close();
                    break;
                }
                channel.writeAndFlush(msg);
            }
        }).start();

        // 处理channel.close()之后的操作
        // (1)
        ChannelFuture closeFuture = channel.closeFuture();
        /*
        System.out.println("waiting close..");
        closeFuture.sync();
        System.out.println("close之后的操作");
         */

        // (2)
        closeFuture.addListener((ChannelFutureListener) future -> {
            System.out.println("close之后的操作");

            // 这里是处理,channel.close之后,main还是不关闭的问题
            // 主要是因为group里面还有线程,导致main不能关闭
            group.shutdownGracefully();
        });

        /*
        // 处理方法2
        channelFuture.addListener((ChannelFutureListener) channelFuture1 -> {
            Channel channel1 = channelFuture1.channel();
            channel1.writeAndFlush("Scarlet!!!");
        });
         */
    }
}