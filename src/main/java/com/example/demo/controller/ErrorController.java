package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {
    @GetMapping("/trigger-error")
    public String triggerError() {
        throw new RuntimeException("Simulated error.");
    }

    @GetMapping("/trigger-error-2")
    public String triggerError2() {
        throw new RuntimeException("Simulated error.");
    }
}