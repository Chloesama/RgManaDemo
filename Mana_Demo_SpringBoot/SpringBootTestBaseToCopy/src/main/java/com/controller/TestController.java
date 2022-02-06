package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        System.out.println("Scarlet Hello!!!");
        log.info("Scarlet Hello!!!");
        return "Scarlet Hello!!!";
    }
}
