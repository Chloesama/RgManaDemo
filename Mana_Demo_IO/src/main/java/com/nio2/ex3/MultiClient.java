package com.nio2.ex3;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @ClassName MultiClient
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/29 22:52
 * @Version 1.0
 **/
public class MultiClient {
    public static void main(String[] args){
        try {
            SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
            sc.write(Charset.defaultCharset().encode("123456789"));
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}