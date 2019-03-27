package com.huhaoran.esproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/center")
    public String adminCenterPage() {
        return "admin/center";
    }

    @GetMapping("/welcome")
    public String adminWelcomePage() {
        return "admin/welcome";
    }
    @GetMapping("/login")
    public String adminLoginPage() {
        return "admin/login";
    }
}
