package com.example.book_library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BookController {
    // @Autowired
    // private BookService bookService;
    /*
     * 新增book
     */
    // @PostMapping("test2")

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
