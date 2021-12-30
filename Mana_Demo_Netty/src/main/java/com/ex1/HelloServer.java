package com.ex1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @ClassName HelloServer
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/30 21:50
 * @Version 1.0
 **/
public class HelloServer {
    public static void main(String[] args) {
        // 1.服务器端的启动器 负责组装netty组件,启动服务器
        new ServerBootstrap()
                // 2.WorkerEvenLoop(selector,thread)
                .group(new NioEventLoopGroup())
                // 3.选择服务器的ServerSocketChannel实现
                .channel(NioServerSocketChannel.class)
                // 4.boss负责处理连接,worker(child)负责读写
                .childHandler(
                        // 5.channel 代表和客户端数据读写的通道,Initializer 初始化,负责添加别的handler
                        new ChannelInitializer<NioSocketChannel>() {
                            @Override
                            protected void initChannel(NioSocketChannel ch) throws Exception {
                                // 6.添加具体的handler
                                // 将ByteBuf转换为字符串(String)
                                ch.pipeline().addLast(new StringDecoder());
                                // 自定义handler
                                ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                        //打印上一步转换好的字符串
                                        System.out.println("Scarlet:" + msg);
                                    }
                                });
                            }
                        })
                //绑定的端口
                .bind(9999);
    }
}