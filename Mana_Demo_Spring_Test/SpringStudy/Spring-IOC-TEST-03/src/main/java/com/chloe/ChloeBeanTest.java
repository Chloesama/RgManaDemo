package com.chloe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName ChloeBeanTest
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/28 21:45
 * @Version 1.0
 **/
@Component
public class ChloeBeanTest {
    ChloeBean chloeBean;

    @Autowired
    public ChloeBeanTest(ChloeBean chloeBean) {
        this.chloeBean = chloeBean;
    }
}
