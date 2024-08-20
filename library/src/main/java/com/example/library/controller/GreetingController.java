package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Frontdesk TEST
@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greet(@RequestParam(name = "name", required = false, defaultValue = "World22222") String name,
            Model model) {
        model.addAttribute("name", name);
        return "greeteet";
    }
}

// path
// src\main\java\com\example \library\controller\GreetingController.java
// \servingwebcontent/GreetingController.java

// src/main/resources/templates/greeting.html
