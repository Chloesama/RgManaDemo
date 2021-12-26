package com.bio.ex2.file.upload;

import lombok.AllArgsConstructor;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * @ClassName ServerReaderThread
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 12:15
 * @Version 1.0
 **/
@AllArgsConstructor
public class ServerReaderThread implements Runnable {
    private Socket socket;

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String suffix = dis.readUTF();

            OutputStream os = new FileOutputStream("E:\\Scarlet_test\\" + UUID.randomUUID() + suffix);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = dis.read(buffer)) > 0) {
                os.write(buffer, 0, len);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}