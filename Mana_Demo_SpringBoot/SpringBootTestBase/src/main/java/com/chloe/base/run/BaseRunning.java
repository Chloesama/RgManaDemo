package com.chloe.base.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName BaseRunning
 * @Description TODO
 * @Author RgMana
 * @Date 2022/1/5 23:30
 * @Version 1.0
 **/
@Slf4j
@Component
public class BaseRunning implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("BaseRunning-这里是初始化线程!!");
    }
}