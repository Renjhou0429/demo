package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/trigger-error")
public class ErrorController {
    @GetMapping("/trigger-error2")
    public String triggerError2(@RequestParam(defaultValue = "N") String crash) {
        if ("Y".equalsIgnoreCase(crash)) {
            throw new RuntimeException("Simulated error.");
        }
        return "No error triggered.";
    }
}