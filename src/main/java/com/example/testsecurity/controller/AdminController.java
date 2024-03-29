package com.example.testsecurity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AdminController {

    @GetMapping("/admin")
    public String adminPage() {
        log.info("adminPage()");
        return "admin";
    }
}
