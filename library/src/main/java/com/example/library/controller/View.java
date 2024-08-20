package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class View {
    /**
     * R get student by ID
     * http://localhost:8080/viewstudent
     */
    @GetMapping("/viewstudent")
    public String greet() {
        return "student";
    }
}
