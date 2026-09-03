package com.ak.Employee.controller;

public class BadCodeExample {

    public String processUser(String username, String password) {

        if (username == null || username.isBlank()) {
            return null;
        }

        if (password != null && password.length() > 0) {
            System.out.println("User password is: " + password);
        }

        String result = "";

        for (int i = 0; i < 5; i++) {
            result = result + username + i;
        }

        if (username.equals("admin")) {
            return "Administrator access granted";
        } else {
            return result;
        }
    }
}