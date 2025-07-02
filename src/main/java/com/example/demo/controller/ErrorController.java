package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {
    @GetMapping("/trigger-error")
    public String triggerError2(@RequestParam(defaultValue = "N") String crash) {
        System.out.println("crash param: " + crash);
        if ("Y".equalsIgnoreCase(crash)) {
            throw new RuntimeException("Simulated error.");
        }
        return "No error triggered.";
    }

    @PostMapping("/validate-triangle")
    public String validateTriangle(@RequestParam int a, @RequestParam int b, @RequestParam int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive numbers");
        }
        
        if (a + b > c && a + c > b) {
            return "Valid triangle";
        }
        
        return "Invalid triangle";
    }

}
