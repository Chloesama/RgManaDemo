package com.chloe.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName ChloeTestScheduled
 * @Description TODO
 * @Author RgMana
 * @Date 2022/2/4 23:46
 * @Version 1.0
 **/
@Slf4j
@Component
@EnableScheduling
public class ChloeTestScheduled {
    @Scheduled(cron = "0/5 * * * * ?")
    public void testScheduled() {
        log.info("调度任务5s一次!!!");
    }
}