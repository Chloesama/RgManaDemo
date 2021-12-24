package com.chloe.paramsTest;

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
@Component
public class GetYmlParamsTest {
    @Value("${chloe.test.path}")
    String path;


    @PostConstruct
    public void test(){
        System.out.println("Scarlet:" + path);
    }
}
