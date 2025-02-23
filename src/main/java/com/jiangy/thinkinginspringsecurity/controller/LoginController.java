package com.jiangy.thinkinginspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>创建时间: 2025/2/23 </p>
 *
 * @author <a href="mailto:jiangliu0316@outlook.com" rel="nofollow">蒋勇</a>
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
