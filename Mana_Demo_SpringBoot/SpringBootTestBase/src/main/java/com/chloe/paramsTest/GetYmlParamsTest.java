package com.chloe.paramsTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName GetYmlParamsTest
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/3 15:37
 * @Version 1.0
 **/
@Slf4j
@Component
public class GetYmlParamsTest {
    @Value("${chloe.test.path}")
    String path;


    @PostConstruct
    public void test(){
        log.info("Scarlet:" + path);
    }
}
