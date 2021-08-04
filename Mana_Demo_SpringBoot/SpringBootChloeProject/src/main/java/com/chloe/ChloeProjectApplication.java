package com.chloe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ChloeApplication
 * @Description TODO
 * @Author RgMana
 * @Date 2021/6/28 10:38
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(value = "com.chloe.mapper")
public class ChloeProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChloeProjectApplication.class);
    }
}
