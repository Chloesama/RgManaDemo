package com.chloe;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName ChloeApplication
 * @Description TODO
 * @Author RgMana
 * @Date 2021/6/28 10:38
 * @Version 1.0
 **/
@MapperScan({"com.chloe.mapper"})
@SpringBootApplication
public class ChloeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChloeApplication.class);
    }
}
