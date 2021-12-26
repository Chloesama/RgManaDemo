package com.bio.ex1;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @ClassName ServerRunnableTarget
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 11:44
 * @Version 1.0
 **/
@AllArgsConstructor
public class ServerRunnableTarget implements Runnable {

    private Socket socket;

    @Override
    public void run() {
        try {
            // 3.从Socket管道中得到一个字节输入流对象
            InputStream is = socket.getInputStream();
            // 4.把字节输入流包装成一个缓冲字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String msg;

            while ((msg = br.readLine()) != null) {
                System.out.println("服务端接收- " + Thread.currentThread() + ":" + msg);
            }

            System.out.println(Thread.currentThread());
            System.out.println("===服务端结束===");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}