package com.example.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.mapper.BookMapper;
import com.example.library.pojo.entity.Book;
import com.example.library.pojo.entity.Lend;
import com.example.library.service.LendService;

@Service
@Transactional
public class LendServiceImpl implements LendService {
    @Autowired
    private BookMapper bookMapper;

    // TODO 先判断是否可借书
    // 获取图书id的集合

    // 可借书
    // 更变书的数量
    // 将该图书ID、读者编号插入到数据库中的借书表中
    @Override
    public void addlend(int book_id, int student_id) {

        Book book = bookMapper.getById(book_id);
        if (book.getCounts() > 0) {
            Lend lend = new Lend();
            lend.setStudent_id(student_id);
            lend.setBook_id(book_id);
            //
            // lendMapper.createLoan(loan);
            // bookMapper.decrementBookCount(book_id);
            // return true;
            // } else {
            // return false;
            // }
        }
    }
}