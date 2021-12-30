package com.ex2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.charset.Charset;

/**
 * @ClassName EvenLoopServer
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/30 23:01
 * @Version 1.0
 **/
public class EventLoopServer {
    public static void main(String[] args) {
        EventLoopGroup group = new DefaultEventLoopGroup();
        new ServerBootstrap()
                // boss(accept) 和worker(socketChannel上的读写)的任务划分
                .group(new NioEventLoopGroup(), new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast( "handler1", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf buf = (ByteBuf) msg;
                                System.out.println(Thread.currentThread());
                                System.out.println(buf.toString(Charset.defaultCharset()));
                                ctx.fireChannelRead(msg);
                            }
                        }).addLast(group, "handler2", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf buf = (ByteBuf) msg;
                                System.out.println(Thread.currentThread());
                                System.out.println(buf.toString(Charset.defaultCharset()));
                            }
                        });
                    }
                })
                .bind(9999);
    }
}