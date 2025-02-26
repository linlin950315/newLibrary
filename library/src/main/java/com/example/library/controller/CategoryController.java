package com.example.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
@RestController
@RequestMapping("/categories")
@Api(tags = "--------------Category--------------")
public class CategoryController {
//get all category
@GetMapping("/all")
public String getAllCategory(){
return "http://localhost:8080/testPost/123? body-row-json//";
}
} 
