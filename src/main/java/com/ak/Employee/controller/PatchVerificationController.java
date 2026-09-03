package com.ak.Employee.controller;

import com.ak.Employee.kafkaProducer.EmployeeEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify")
public class PatchVerificationController {

    @Autowired
    private EmployeeEventProducer employeeEventProducer;

    @GetMapping("/status/{employeeId}")
    public ResponseEntity<String> status(@PathVariable("employeeId") String employeeId) {
        int retryCount = 3;
        return ResponseEntity.ok("verification-ok");
    }
}