package com.nio.ex1.channel;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName ChannelTest
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 22:05
 * @Version 1.0
 **/
public class ChannelTest {
    /**
     * 写文件
     */
    @Test
    public void write() {
        try {
            FileOutputStream fos = new FileOutputStream("E:\\Scarlet_test\\data01.txt");
            FileChannel channel = fos.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("Scarlet!!!".getBytes(StandardCharsets.UTF_8));
            buffer.flip();
            channel.write(buffer);
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void read() {
        try {
            FileInputStream fis = new FileInputStream("E:\\Scarlet_test\\data01.txt");
            FileChannel channel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            channel.read(buffer);
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, buffer.remaining()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copy() {
        try {
            File srcFile = new File("C:\\Users\\47691\\Desktop\\test.jpg");
            File destFile = new File("E:\\Scarlet_test\\newTest.jpg");

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            FileChannel isChannel = fis.getChannel();
            FileChannel osChannel = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                buffer.clear();
                int flag = isChannel.read(buffer);
                if (flag == -1) {
                    break;
                }
                buffer.flip();
                osChannel.write(buffer);
            }
            isChannel.close();
            osChannel.close();

            System.out.println("复制完成!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓冲区的分散和聚集
     */
    @Test
    public void test() {
        try {
            FileInputStream fis = new FileInputStream("E:\\Scarlet_test\\data01.txt");
            FileOutputStream fos = new FileOutputStream("E:\\Scarlet_test\\data02.txt");

            FileChannel isChannel = fis.getChannel();
            FileChannel osChannel = fos.getChannel();

            ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);

            ByteBuffer[] buffers = {byteBuffer1, byteBuffer2};


            isChannel.read(buffers);

            for (ByteBuffer buffer : buffers) {
                buffer.flip();
                System.out.println(new String(buffer.array(), 0, buffer.remaining()));
            }

            osChannel.write(buffers);

            isChannel.close();
            osChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        try {
            FileInputStream fis = new FileInputStream("E:\\Scarlet_test\\data01.txt");
            FileOutputStream fos = new FileOutputStream("E:\\Scarlet_test\\data02.txt");
            FileOutputStream fos2 = new FileOutputStream("E:\\Scarlet_test\\data03.txt");

            FileChannel isChannel = fis.getChannel();
            FileChannel osChannel = fos.getChannel();
            FileChannel osChannel2 = fos2.getChannel();

            osChannel.transferFrom(isChannel,isChannel.position(),isChannel.size());

            isChannel.position(0);

            isChannel.transferTo(isChannel.position(),isChannel.size(),osChannel2);

            isChannel.close();
            osChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}