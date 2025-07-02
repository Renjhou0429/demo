package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {
    @GetMapping("/triangle-error")
    public String triangleError(@RequestParam(defaultValue = "N") String crash) {
        if ("Y".equalsIgnoreCase(crash)) {
            throw new RuntimeException("Simulated error.");
        }
        return "No error triggered.";
    }

    @GetMapping("/validate-triangle")
    public String validateTriangle(@RequestParam int a, @RequestParam int b, @RequestParam int c) {
        int typeIndex = -1;
        String[] triangleTypes = {
            "Equilateral Triangle",
            "Isosceles Triangle", 
            "Scalene Triangle"
        };
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive numbers.");
        }
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                typeIndex = 0;
            } else if (a == b || b == c || a == c) {
                typeIndex = 1;
            } else {
                typeIndex = 2;
            }
        } else {
            throw new IllegalArgumentException("Triangle sides must be positive numbers.");
        }
        return triangleTypes[typeIndex];
    }
}