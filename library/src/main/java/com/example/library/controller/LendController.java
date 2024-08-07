package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.service.LendService;
import com.example.library.util.Result;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/lend")
@Api(tags = "--------------LEND--------------")
public class LendController {

    @Autowired
    LendService lendService;

    /**
     * 借书
     * http://localhost:8080/admin/lend/addLend?book_id=4&student_id=1
     * *
     */
    @PutMapping("/addLend")
    public Result<String> lendAbook(@RequestParam int book_id, @RequestParam int student_id) {
        lendService.lendAbook(book_id, student_id);
        return Result.success();
    }

    /**
     * 查询借书信息
     * select
     *
     * from
     * lend l
     * book b ON l.bookId = b.book_id
     * 
     */

}
