package com.bio.ex2.file.upload;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName Client
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 12:09
 * @Version 1.0
 **/
public class Client {

    private static String ipaddress = "127.0.0.1";
    private static Integer port = 9999;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(ipaddress, port);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String fileSuffix = ".jpg";
            dos.writeUTF(fileSuffix);

            InputStream is = new FileInputStream("C:\\Users\\47691\\Desktop\\test.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0) {
                dos.write(buffer, 0, len);
            }
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}