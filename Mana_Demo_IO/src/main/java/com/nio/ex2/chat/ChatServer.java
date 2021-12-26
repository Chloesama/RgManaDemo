package com.nio.ex2.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * @ClassName ChatServer
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 22:59
 * @Version 1.0
 **/
public class ChatServer {
    private Selector selector;
    private ServerSocketChannel ssChannel;
    private static final Integer PORT = 9999;

    public ChatServer() {
        try {
            selector = Selector.open();
            ssChannel = ServerSocketChannel.open();
            ssChannel.bind(new InetSocketAddress(PORT));
            ssChannel.configureBlocking(false);
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            while (selector.select() > 0) {
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey sk = it.next();
                    if (sk.isAcceptable()) {
                        SocketChannel sChannel = ssChannel.accept();
                        sChannel.configureBlocking(false);
                        sChannel.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        readClientData(sk);
                    }
                    it.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readClientData(SelectionKey sk) {
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) sk.channel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int count = channel.read(buf);
            if (count > 0) {
                buf.flip();
                String msg = new String(buf.array(), 0, buf.remaining());
                System.out.println("接收到的信息:" + msg);
                sendMsgToAllClient(msg, channel);
            }
        } catch (Exception e) {
            sk.cancel();
            try {
                System.out.println("有人离线了!!");
                channel.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
//            e.printStackTrace();
        }
    }

    private void sendMsgToAllClient(String msg, SocketChannel channel) {
        for (SelectionKey key : selector.keys()) {
            Channel keyChannel = key.channel();
            if (keyChannel instanceof SocketChannel) {
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
                try {
                    ((SocketChannel) keyChannel).write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.listen();
    }
}