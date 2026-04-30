package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller   // ← 注意：不是 @RestController（因為要回傳 HTML 頁面，不是 JSON）
public class AuthController {

    // GET /login → 渲染 templates/login.html
    @GetMapping("/login")
    public String loginPage() {
        return "login";    // Thymeleaf 會到 templates/ 資料夾找 login.html
    }

    // GET /welcome → 渲染 templates/welcome.html
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
