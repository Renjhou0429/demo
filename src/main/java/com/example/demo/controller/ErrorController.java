package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {
    @GetMapping("/trigger-error")
    public String triggerError(@RequestParam(defaultValue = "N") String crash) {
        if ("Y".equalsIgnoreCase(crash)) {
            throw new new RuntimeException("Simulated error.");
        }
        return "No error triggered.";
    }

    @GetMapping("/validate-triangle")
    public String validateTriangle(@RequestParam int a, @RequestParam int b, @RequestParam int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive numbers.");
        }
        <--- NEW CODE STARTS HERE
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("The provided values do not form a triangle.");
        }
        <--- NEW CODE ENDS HERE
        return "Valid triangle.";
    }
}