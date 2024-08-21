package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class View {
    /**
     * admin 管理员页面 根据id 查姓名和正在借的书
     * http://localhost:8080/admin
     */
    @GetMapping("/admin")
    public String adminpage() {
        return "admin";
    }

    /**
     * user 用户页面 学生进行借书操作
     * http://localhost:8080/user
     */
    @GetMapping("/user")
    public String user() {
        return "user";
    }

}
