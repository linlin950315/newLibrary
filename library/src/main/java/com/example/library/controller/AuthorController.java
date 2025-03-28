package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.pojo.dto.AuthorDTO;
import com.example.library.pojo.entity.Author;
import com.example.library.service.AuthorService;
import com.example.library.util.Result;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/author")
@Api(tags = "--------------AuthorC--------------")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

//insert
    @PostMapping("/insert")
    public Result<Integer> insertAuthorBatch(@RequestBody List<AuthorDTO> authorDTO) {
        System.out.println("----------AutherController---------" + authorDTO);
        int rows = authorService.insertAuthor(authorDTO);
        return Result.success(rows);
    }

    //insert and update
    @PostMapping("/addBatchJPA")
    public List<Author> addAuthors(@RequestBody List<String> authorNames) {
        return authorService.addAuthors(authorNames);
    }

    @GetMapping("/addAuthorsWithCheck") //http://localhost:8080/admin/author/addAuthorsWithCheck
    public List<Author> addAuthorsWithCheck(@RequestBody List<String> authorNames) {
        return authorService.addAuthorsWithCheck(authorNames);
    }

}
