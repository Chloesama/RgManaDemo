package com.rgmana.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author RgMana
 * @Date 2021/8/4 11:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("Chloe")
    public String Chloe(){
        System.out.println("Chloe");
        return "Chloe";
    }

}
