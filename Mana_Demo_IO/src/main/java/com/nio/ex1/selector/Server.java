package com.nio.ex1.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName Server
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 22:36
 * @Version 1.0
 **/
public class Server {
    public static void main(String[] args) {
        try {
            // 1.获取通道
            ServerSocketChannel ssChannel = ServerSocketChannel.open();
            // 2.切换为非阻塞模式
            ssChannel.configureBlocking(false);
            // 3.绑定连接端口
            ssChannel.bind(new InetSocketAddress(9999));
            // 4.获取连接器Selector
            Selector selector = Selector.open();
            // 5.将通道都注册到选择器上去,并且开始指定监听接收事件
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
            // 6.使用Selector选择器轮询已经就绪好的事件
            while (selector.select() > 0) {
                // 7.获取选择器中的所有注册的通道中已经就绪好的事件
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                // 8.开始遍历这些准备好的事件
                while (it.hasNext()) {
                    SelectionKey sk = it.next();
                    if (sk.isAcceptable()) {
                        SocketChannel sChannel = ssChannel.accept();
                        sChannel.configureBlocking(false);
                        sChannel.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        SocketChannel sChannel = (SocketChannel) sk.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = sChannel.read(buffer)) > 0) {
                            System.out.println("读取数据");
                            buffer.flip();
                            System.out.println(new String(buffer.array(), 0, buffer.remaining()));
                            buffer.clear();
                        }
                    }
                    it.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}