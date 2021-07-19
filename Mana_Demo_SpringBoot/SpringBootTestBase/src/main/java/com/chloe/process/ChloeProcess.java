package com.chloe.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName ChloeProcess
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/12 14:35
 * @Version 1.0
 **/
@Component
@Slf4j
public class ChloeProcess {

    @PostConstruct
    public void test(){
        log.info("Chloe!!!!");
    }
}
