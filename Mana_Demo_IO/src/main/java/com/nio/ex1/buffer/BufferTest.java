package com.nio.ex1.buffer;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName BufferTest
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/26 21:48
 * @Version 1.0
 **/
public class BufferTest {
    /**
     * 对NIO 缓冲区的API 了解
     */
    @Test
    public void test01(){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("----------------------------");

        String name = "Scarlet";
        buffer.put(name.getBytes(StandardCharsets.UTF_8));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("----------------------------");

        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("----------------------------");

        char ch = (char) buffer.get();
        System.out.println(ch);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
    }

    @Test
    public void test02(){
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("----------------------------");

        String name = "Scarlet";
        buffer.put(name.getBytes(StandardCharsets.UTF_8));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("----------------------------");

        buffer.clear();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println((char)buffer.get());

        System.out.println("----------------------------");
        ByteBuffer buf = ByteBuffer.allocate(10);
        String n = "Scarlet";
        buf.put(n.getBytes(StandardCharsets.UTF_8));
        buf.flip();
        byte[] b = new byte[2];
        buf.get(b);
        String rs = new String(b);
        System.out.println(rs);
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("----------------------------");
        buf.mark();
        byte[] b2 = new byte[3];
        buf.get(b2);
        System.out.println(new String(b2));
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("----------------------------");
        buf.reset();
        if(buf.hasRemaining()){
            System.out.println(buf.remaining());
        }
    }

    @Test
    public void test03(){
        Buffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.isDirect());
    }
}