package com.example.library.service.impl;

import org.hibernate.mapping.List;

import com.example.library.service.LendService;

public class LendServiceImpl implements LendService {
    // TODO 先判断是否可借书
    // 获取图书id的集合

    // 可借书
    // 更变书的数量
    // 将该图书ID、读者编号插入到数据库中的借书表中

    @Override
    public void addlend() {
        List<String> bookklist = Arrays.asList(ids.split(","));
    }
}