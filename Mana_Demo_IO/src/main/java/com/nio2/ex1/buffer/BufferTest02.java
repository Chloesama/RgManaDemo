package com.nio2.ex1.buffer;

import org.junit.Test;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName BufferTest02
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/27 22:21
 * @Version 1.0
 **/
public class BufferTest02 {
    @Test
    public void test01() {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nIm zhangsan\nHo".getBytes(StandardCharsets.UTF_8));
        split(source);
        source.put("w are you?\n".getBytes(StandardCharsets.UTF_8));
        split(source);
    }

    private static void split(ByteBuffer source) {
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int length = i + 1 - source.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
            }
        }
        source.compact();
    }

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