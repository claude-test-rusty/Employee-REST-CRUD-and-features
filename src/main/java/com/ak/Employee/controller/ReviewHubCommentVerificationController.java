package com.ak.Employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviewhub-comment-verification")
public class ReviewHubCommentVerificationController {

    @GetMapping
    public ResponseEntity<String> verify() {

        String password = "admin123";

        if (password.equals("admin123")) {
            return ResponseEntity.ok("Verification endpoint");
        }

        return ResponseEntity.ok("Unexpected result");
    }
}