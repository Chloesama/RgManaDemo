package com.rgmana4.log;

import mana.util.file.FileUtil;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName LogManage
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/4 11:23
 * @Version 1.0
 **/
public class LogManage {
    private BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    public LogManage(){
        new Thread(new LogThread()).start();
    }

    public void info(String log) {
        blockingQueue.offer(log);
    }

    class LogThread implements Runnable{

        @Override
        public void run() {
            while (true){
                String log = blockingQueue.poll();
                if(StringUtils.isNotBlank(log)){
                    FileUtil.writeFile("E:\\workFile\\logs\\Chloe_log","info.log",log);
                }
            }
        }
    }
}
