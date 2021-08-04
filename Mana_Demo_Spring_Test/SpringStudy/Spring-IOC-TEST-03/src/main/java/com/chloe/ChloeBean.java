package com.chloe;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName ChloeBean
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/27 10:19
 * @Version 1.0
 **/
@Component
public class ChloeBean implements InitializingBean {

    public ChloeBean(){
        System.out.println("ChloeBean 构造器...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ChloeBean afterPropertiesSet...");
    }
}
