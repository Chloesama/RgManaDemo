package com.nio2.ex1.buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName BufferTest02
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/27 22:21
 * @Version 1.0
 **/
public class BufferTest02 {
    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("E:\\Scarlet_test\\test.txt").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(5);
            StringBuffer sb = new StringBuffer();
            while (channel.read(buffer) > 0) {
                buffer.flip();
                String str = new String(buffer.array(), 0, buffer.remaining());
                buffer.clear();
                System.out.print(str);
                sb.append(str);
            }
            System.out.println();
            System.out.println("Chloe:\n" + sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}