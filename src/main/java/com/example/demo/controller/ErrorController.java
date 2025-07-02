package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {
    @GetMapping("/trigger-error")
    public String validateTriangle(@RequestParam(defaultValue = "N") String crash) {
        System.out.println("crash param: " + crash);
        if ("Y".equalsIgnoreCase(crash)) {
            throw new New RuntimeException("Simulated error.");
        }
        return "No error triggered.";
    }

    @GetMapping("/validate-triangle")
    public String validateTriangleParameters(@RequestParam int a, @RequestParam int b, @RequestParam int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive numbers.");
        }
        int[] triangleTypes = {-1}; // Initialize with -1 to indicate invalid
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                triangleTypes[0] = 0; // Equilateral
            } else if (a == b || b == c || a == c) {
                triangleTypes[0] = 1; // Isosceles
            } else {
                triangleTypes[0] = 2; // Scalene
            }
        }
        return triangleTypes;
    }
}