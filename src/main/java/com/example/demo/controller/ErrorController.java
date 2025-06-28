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

}
