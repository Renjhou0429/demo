package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {
    @GetMapping("/trigger-error")
    public String triggerError() {
        return "This will not trigger an error.";
    }

    @GetMapping("/trigger-error2")
    public String triggerError2(@RequestParam(defaultValue = "N") String trash) {
        if ("Y".equalsIgnoreCase(trash)) {
            throw new RuntimeException("Simulated error.");
        }
        return "No error triggered.";
    }
}