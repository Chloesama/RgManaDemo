package com.chloe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName ChloeMain
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/28 20:38
 * @Version 1.0
 **/
public class ChloeMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
}
