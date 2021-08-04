package com.mayikt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 自定义 LoginController
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}