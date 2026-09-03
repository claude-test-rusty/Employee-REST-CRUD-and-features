package com.ak.Employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdempotencyTestController {

    @GetMapping("/idempotency-test")
    public String test() {
        String abc = "This intentionally creates a PMD finding";
        return "Idempotency test";
    }
}