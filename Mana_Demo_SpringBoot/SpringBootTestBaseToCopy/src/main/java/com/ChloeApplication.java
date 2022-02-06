package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName ChloeApplication
 * @Description TODO
 * @Author RgMana
 * @Date 2021/6/28 10:38
 * @Version 1.0
 **/
@SpringBootApplication
public class ChloeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChloeApplication.class);
    }
}
