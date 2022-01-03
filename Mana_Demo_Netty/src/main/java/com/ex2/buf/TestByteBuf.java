package com.ex2.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.nio.charset.StandardCharsets;

import static io.netty.buffer.ByteBufUtil.appendPrettyHexDump;
import static io.netty.util.internal.StringUtil.NEWLINE;


/**
 * @ClassName TestByteBuf
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/31 16:42
 * @Version 1.0
 **/
public class TestByteBuf {
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
//        ByteBufAllocator.DEFAULT.heapBuffer(10);
//        ByteBufAllocator.DEFAULT.directBuffer(10);
        System.out.println(buf);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 300; i++) {
            sb.append("a");
        }
        buf.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8));
        log(buf);
    }

    private static void log(ByteBuf buf) {
        int len = buf.readableBytes();
        int rows = len / 16 + (len % 15 == 0 ? 0 : 1) + 4;
        StringBuilder b = new StringBuilder(rows * 80 * 2)
                .append("read index:").append(buf.readerIndex())
                .append(" write index:").append(buf.writerIndex())
                .append(" capacity:").append(buf.capacity())
                .append(NEWLINE);
        appendPrettyHexDump(b, buf);
        System.out.println(b);

    }
}