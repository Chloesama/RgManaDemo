package com.bio.ex1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName Client
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 10:51
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            System.out.println("===客服端启动===");
            // 1.创建一个Socket对象请求服务端链接
            socket = new Socket("127.0.0.1", 9999);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("请输入:");
                String msg = sc.nextLine();
                if ("Scarlet".equals(msg)) {
                    break;
                }
                ps.println(msg);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("===客服端关闭===");
        }
    }
}