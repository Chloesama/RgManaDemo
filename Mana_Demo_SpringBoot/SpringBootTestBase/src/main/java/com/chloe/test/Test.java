package com.chloe.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.chloe.pojo.Rgmana;
import com.chloe.service.RgmanaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author RgMana
 * @Date 2021/7/26 15:38
 * @Version 1.0
 **/
@Slf4j
@Component
public class Test {

    @Resource
    RgmanaService rgmanaService;

    public void test() {
        QueryWrapper<Rgmana> queryWrapper = Wrappers.query();
        List<Rgmana> rgmanas = rgmanaService.list(queryWrapper);
        log.info("Chloe:" + rgmanas);
    }
}
