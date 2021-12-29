package com.nio2.ex2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @ClassName WriteServer
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/29 22:07
 * @Version 1.0
 **/
public class WriteServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);

            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ssc.bind(new InetSocketAddress(9999));

            while (selector.select() > 0) {
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey sk = it.next();
                    it.remove();

                    if (sk.isAcceptable()) {
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        SelectionKey skKey = sc.register(selector, 0, 0);
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < 30000000; i++) {
                            sb.append("a");
                        }
                        ByteBuffer buffer = Charset.defaultCharset().encode(sb.toString());

                        //这个write是实际写入的长度
                        int write = sc.write(buffer);
                        System.out.println("Scarlet1:" + write);

                        if (buffer.hasRemaining()) {
                            //如果数据还没写完
                            skKey.interestOps(skKey.interestOps() + SelectionKey.OP_WRITE);
                            skKey.attach(buffer);
                        }
                    } else if (sk.isWritable()) {
                        ByteBuffer buffer = (ByteBuffer) sk.attachment();
                        SocketChannel sc = (SocketChannel) sk.channel();
                        sc.configureBlocking(false);

                        int write = sc.write(buffer);
                        System.out.println("Scarlet2:" + write);
                        if (!buffer.hasRemaining()) {
                            sk.attach(null);
                            sk.interestOps(sk.interestOps() - SelectionKey.OP_WRITE);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}