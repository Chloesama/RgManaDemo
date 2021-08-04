package com.mayikt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统一返回错误异常类
 */
@RestController
public class ErrorController {
    @RequestMapping("/error/403")
    public String error() {
        return "您当前访问的接口权限不足!";
    }
}