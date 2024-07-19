package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.pojo.dto.BookDTO;
import com.example.library.pojo.entity.Student;
import com.example.library.service.BookService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/book")
@Api(tags = "--------------BOOK--------------")
public class BookController {
    @Autowired
    private BookService bookService;

    /*
     * C
     */

    @PostMapping("/{id}")

    public String insert(@RequestBody BookDTO bookDTO) { // 注解@RequestBody用于接收前端传递给后端的、JSON对象的字符串
        bookService.insertBook(bookDTO);
        return bookDTO.getId();
    }

    /*
     * Read
     */
    @GetMapping("/{id}")
    public String getbyId(@PathVariable Long id) {
        return id + "没调Service getbyId";
    }

    /*
     * Update
     */
    @PutMapping()
    public String update(@RequestBody BookDTO bookDTO) {
        return bookDTO.getName() + "没调Service update";
    }

    /*
     * D
     */
    @DeleteMapping("/{id}")
    public String delete(@RequestBody String id) {
        // bookService.deleteBook(id);
        return id + "没调Service delete";
    }

    /*
     * TEST
     */
    @PostMapping("/Post/{id}")
    public String test1(@PathVariable int id, @RequestBody Student student) {
        return "http://localhost:8080/testPost/123? body-row-json//" + student;
    }

    @PostMapping("/testPost/{id}")
    public String test00(@PathVariable int id, @RequestBody Student student) {
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
