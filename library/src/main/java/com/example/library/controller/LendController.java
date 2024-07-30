package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.service.LendService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/lend")
@Api(tags = "--------------LEND--------------")
public class LendController {

    @Autowired
    LendService lendService;

    /**
     * 借书
     * * ids：字符串 书id的集合
     */
    @RequestMapping("/addLend")
    public void borrow(int student_id, int ids) {
        lendService.addlend(student_id, ids);
    }
}