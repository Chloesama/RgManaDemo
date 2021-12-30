package com.ex2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * @ClassName HelloClient
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/30 22:01
 * @Version 1.0
 **/
public class EventClient {
    public static void main(String[] args) throws InterruptedException {
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

    }
}