package com.mana.config;

import com.mana.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan("com.mana.pojo")
@Import(ManaConf2.class)
public class ManaConfig {

    @Bean
    public User getUser(){
        return new User();
    }
}
