package com.bio.ex1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 10:51
 * @Version 1.0
 * <p>
 **/
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("===服务端启动===");
            // 1.定义 一个ServerSocket对象进行服务端端口注册
            ServerSocket ss = new ServerSocket(9999);
            // 2.监听客户端Socket的连接请求
            HandlerSocketServerPool pool = new HandlerSocketServerPool(6, 10);
            while (true) {
                Socket socket = ss.accept();
                pool.execute(new ServerRunnableTarget(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}