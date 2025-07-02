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

    @GetMapping("/validate-triangle")
    public String validateTriangle(@RequestParam int a, @RequestParam int b, @RequestParam int c) {
        int typeIndex = -1;
        String[] triangleTypes = {
            "正三角形 (Equilateral Triangle)",
            "等腰三角形 (Isosceles Triangle)", 
            "不等邊三角形 (Scalene Triangle)"
        };
        
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive numbers");
        }
        
        if (a + b > c && a + c > b) { 
            if (a == b && b == c) {
                typeIndex = 0;
            } else if (a == b || b == c) {
                typeIndex = 1;
            } else {
                typeIndex = 2;
            }
        }

        return triangleTypes[typeIndex];
    }

}
