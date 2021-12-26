package com.nio.ex2.chat;

import lombok.Getter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @ClassName ChatClient
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 23:16
 * @Version 1.0
 **/
public class ChatClient {
    private Selector selector;
    private static Integer PORT = 9999;
    @Getter
    private SocketChannel socketChannel;

    public ChatClient() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ChatClient client = new ChatClient();

            new Thread(() -> {
                client.readInfo();
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String msg = scanner.nextLine();
                if ("Scarlet".equals(msg)) {
                    break;
                }
                client.sendToServer(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendToServer(String msg) throws IOException {
        socketChannel.write(ByteBuffer.wrap(("Scarlet:" + msg).getBytes()));
    }

    private void readInfo() {
        try {
            while (selector.select() > 0) {
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey sk = it.next();
                    if (sk.isReadable()) {
                        SocketChannel channel = (SocketChannel) sk.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        System.out.println("接收到信息:" + new String(buffer.array()).trim());
                    }
                    it.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}