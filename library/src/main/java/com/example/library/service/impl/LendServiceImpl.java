package com.example.library.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.pojo.entity.Book;
import com.example.library.pojo.entity.Lend;
import com.example.library.service.LendService;

@Service
@Transactional
public class LendServiceImpl implements LendService {
    // TODO 先判断是否可借书
    // 获取图书id的集合

    // 可借书
    // 更变书的数量
    // 将该图书ID、读者编号插入到数据库中的借书表中

    @Override
    public void addlend(int student_id, int ids) {

        List<Book> bookklist = new ArrayList<>(Arrays.asList(Integer.toString(ids).split(",")));
        for (String book_id : bookklist) {
            Lend lendList = new Lend();
            lendList.getStudent_id();// 读者id
            lendList.getBook_id();// 书的id
        }

    }
}