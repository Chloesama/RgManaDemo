package com.aio.ex1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName AioFileChannel
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/30 21:34
 * @Version 1.0
 **/
public class AioFileChannel {
    public static void main(String[] args) {
        try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("E:\\Scarlet_test\\test.txt"), StandardOpenOption.READ)) {
            // 1.ByteBuffer
            // 2.读取的起始位置
            // 3.附件
            // 4.回调方法
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            System.out.println("read begin...");
            channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                //读取成功
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("read completed!");
                    //result读取的字节数
                    attachment.flip();
                    System.out.println(new String(attachment.array(), 0, attachment.remaining()));
                }

                //读取失败
                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {

                }
            });

            System.out.println("read end...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}