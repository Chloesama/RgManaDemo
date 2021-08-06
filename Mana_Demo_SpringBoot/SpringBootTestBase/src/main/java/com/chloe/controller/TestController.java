package com.chloe.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.chloe.pojo.Rgmana;
import com.chloe.redis.RedisUtil;
import com.chloe.service.RgmanaService;
import com.chloe.srv.ChloeSrv;
import lombok.extern.slf4j.Slf4j;
import mana.util.json.JsonUtil;
import org.apache.poi.ss.formula.functions.Choose;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Rgmana
 * @Date 2021/6/28 10:43
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Resource
    RedisUtil redisUtil;

    @Resource
    RgmanaService rgmanaService;

    @Resource
    ChloeSrv chloeSrv;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){

        redisUtil.set("Chloe","Chloe1-Rgmana");

        String Chloe = (String)redisUtil.get("Chloe");
        log.info("Chloe:" + Chloe);

        Map<String,String> testMap = new HashMap<>(1);
        testMap.put("test1","1");
        testMap.put("test2","2");
        testMap.put("test3","3");

        redisUtil.set("test", JsonUtil.toFastJsonByObject(testMap));

        String test = (String) redisUtil.get("test");

        log.info("test:" + JsonUtil.getObjectByFactJson(test,Map.class));
        return "Chloe hello";
    }

    @ResponseBody
    @RequestMapping("Chloe")
    public String Chloe(){
        QueryWrapper<Rgmana> queryWrapper = Wrappers.query();
//        queryWrapper.lambda().eq(Rgmana::getT1,"1");
        List<Rgmana> rgmanas = rgmanaService.list(queryWrapper);
        log.info("Chloe:" + rgmanas);
        return rgmanas.toString();
    }

    @PostMapping("PostChloe")
    public Map<String,Object> PostChloe(@RequestBody Map<String,Object> data){
        log.info("PostChloe:" + data);
        String user = (String) data.get("user");
        Map<String,Object> resultMap = new HashMap<>(1);
        resultMap.put("user",user);
        return resultMap;
    }

    @GetMapping("AnnotationAopThread")
    public String AnnotationAopThread(){
        log.info("Chloe1");
        chloeSrv.testChloe();
        log.info("Chloe2");
        return "Chloe!!!";
    }
}
