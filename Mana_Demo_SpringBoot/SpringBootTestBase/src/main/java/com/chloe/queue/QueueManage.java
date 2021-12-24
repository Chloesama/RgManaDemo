package com.chloe.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName QueueManage
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/3 11:03
 * @Version 1.0
 **/
public enum QueueManage {
    /**
     * 单例模式
     */
    INSTANCE;

    /**
     * 队列
     */
    private ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(1024 * 1024);

    /**
     * 加入队列
     *
     * @param data
     */
    public void add(Object data) {
        queue.offer(data);
    }

    /**
     * 取出队列里的所有的记录
     *
     * @return
     */
    public Object task() {
        try {
            return queue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
