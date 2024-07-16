package com.example.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.pojo.entity.Student;

@RestController
public class BookController {
    // @Autowired
    // private BookService bookService;
    /*
     * 新增book
     */
    @PostMapping("/testPost/{id}")
    public String test1(@PathVariable int id, @RequestBody Student student) {
        return "http://localhost:8080/testPost/123? body-row-json//" + student;
    }

    @GetMapping("/testGET/{id}/{ids}")
    public String test2(@PathVariable() int id, @PathVariable int ids,
            @RequestParam(required = false) String name) {
        return "http://localhost:8080/testGET/111/222?" + ";name=" + name + ";ids=" + ids + ";id=" + id;
    }

    @PutMapping("/testput/{id}")
    public String test3(@PathVariable int id, @RequestParam String name) {
        return "http://localhost:8080/testput/123?name=aaa" + name + id;
    }

    // if@RequestBody "error": "Bad Request"
    @PutMapping("/RequestBody/{id}")
    public String test4(@PathVariable int id, @RequestBody String name) {
        return "http://localhost:8080/RequestBody/123?name=aaa" + id + name;
    }

    // "error": "Bad Request"
    // @PutMapping("/testput/{id2}")
    // public String test3(@PathVariable int id2) {
    // return "http://localhost:8080/testput/123?" + id2;
    // }

    // "error": "Bad Request"
    // @PutMapping("/testput")
    // public String test3(@RequestParam String name) {
    // return "http://localhost:8080/testput/name=aaa?" + name;
    // }

    @DeleteMapping("/testdelete")
    public String testdelete() {
        return "@DeleteMapping(\"/testdelete\")";
    }

}
