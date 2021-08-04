package com.chloe;

import org.springframework.context.annotation.Bean;

/**
 * @ClassName Appconf
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/28 21:59
 * @Version 1.0
 **/
public class AppConf {

    @Bean
    public ChloeBean chloeBean(){
        return new ChloeBean();
    }
}
