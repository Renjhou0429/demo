package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {
    @GetMapping("/trigger-error")
    public String triggerError() {
        throw new RuntimeException("Simulated error.");
    }

    @GetMapping("/trigger-error2")
    public String triggerError2() {
        String input = "N";
        if (input.equals("Y")) {
            throw new RuntimeException("Simulated error.");
        }
        return "No error triggered.";
    }
}
