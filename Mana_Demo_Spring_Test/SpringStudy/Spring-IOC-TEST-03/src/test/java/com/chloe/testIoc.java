package com.chloe;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testIoc
 * @Description TODOcl
 * @Author RgMana
 * @Date 2021/7/27 10:51
 * @Version 1.0
 **/
public class testIoc {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ChloeBean chloeBean = applicationContext.getBean(ChloeBean.class);
        System.out.println(chloeBean);
    }
}
