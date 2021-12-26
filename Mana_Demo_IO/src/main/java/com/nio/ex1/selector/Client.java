package com.nio.ex1.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 22:48
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        try {
            SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
            sChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入:");
                String msg = scanner.nextLine();
                if("Scarlet".equals(msg)){
                    break;
                }

                byteBuffer.put(("Scarlet:" + msg).getBytes(StandardCharsets.UTF_8));
                byteBuffer.flip();
                sChannel.write(byteBuffer);
                byteBuffer.clear();
            }

            sChannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}