package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.pojo.entity.Category;
import com.example.library.service.CategoryService;

import io.swagger.annotations.Api;
@RestController
@RequestMapping("/categories")
@Api(tags = "--------------Category--------------")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
//get all category
@GetMapping("/all") //http://localhost:8080/categories/all
public List<Category> getAll(){
    List<Category> categories = categoryService.getAllCategory();
    System.out.println("----------categories------------"+categories);
return categoryService.getAllCategory();

}
}
