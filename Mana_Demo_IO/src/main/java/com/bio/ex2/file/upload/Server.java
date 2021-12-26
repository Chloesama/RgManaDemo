package com.bio.ex2.file.upload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 12:13
 * @Version 1.0
 **/
public class Server {
    private static Integer port = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                Socket socket = ss.accept();
                new Thread(new ServerReaderThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}