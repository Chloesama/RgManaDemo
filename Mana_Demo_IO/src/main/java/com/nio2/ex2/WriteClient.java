package com.nio2.ex2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @ClassName WriteClient
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/29 22:12
 * @Version 1.0
 **/
public class WriteClient {
    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));

            int count = 0;
            while (true){
                ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
                count += sc.read(buffer);
                System.out.println(count);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}