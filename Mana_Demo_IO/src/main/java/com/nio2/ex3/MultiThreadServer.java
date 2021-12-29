package com.nio2.ex3;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName MultiThreadServer
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/29 22:36
 * @Version 1.0
 **/
public class MultiThreadServer {
    public static void main(String[] args) {
        Thread.currentThread().setName("BOSS");
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            Selector boss = Selector.open();
            ssc.register(boss, SelectionKey.OP_ACCEPT);
            ssc.bind(new InetSocketAddress(9999));
            Worker worker = new Worker("worker-0");

            while (boss.select() > 0) {
                Iterator<SelectionKey> it = boss.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey sk = it.next();
                    it.remove();
                    if (sk.isAcceptable()) {
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        worker.register(sc);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Worker implements Runnable {
        private Thread thread;
        private Selector selector;
        private String name;
        private boolean start = false;

        private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

        public Worker(String name) {
            this.name = name;
        }


        public void register(SocketChannel sc) throws IOException {
            if (!start) {
                thread = new Thread(this, name);
                thread.start();
                selector = Selector.open();
                start = true;
            }
            //向队列里面添加一个任务,但是,没有执行
            queue.add(() -> {
                try {
                    sc.register(selector, SelectionKey.OP_READ);
                } catch (ClosedChannelException e) {
                    e.printStackTrace();
                }
            });

            selector.wakeup();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Chloe1" + (selector == null));
                    selector.select();
                    Runnable task = queue.poll();
                    if (task != null) {
                        task.run();
                    }

                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> it = selectionKeys.iterator();
                    while (it.hasNext()) {
                        SelectionKey sk = it.next();
                        it.remove();
                        if (sk.isReadable()) {
                            try{
                                ByteBuffer buffer = ByteBuffer.allocate(16);
                                SocketChannel sc = (SocketChannel) sk.channel();
                                int read = sc.read(buffer);
                                System.out.println("Scarlet:" + read);
                                if(read == -1){
                                    sk.interestOps(sk.interestOps() - SelectionKey.OP_READ);
                                }else{
                                    buffer.flip();
                                    System.out.println(new String(buffer.array(), 0, buffer.remaining()));
                                }

                            }catch (Exception e){
                                sk.interestOps(sk.interestOps() - SelectionKey.OP_READ);
//                                sk.channel();
                                e.printStackTrace();
                            }

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}