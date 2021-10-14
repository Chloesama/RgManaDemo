package com.chloe.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestUtil
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/25 15:07
 * @Version 1.0
 **/
@Data
@Component
public class TestUtil {

    @Value("${chloe.test.path}")
    String path;

    public TestUtil(){
        System.out.println("Chloe:" + path);
    }
}
