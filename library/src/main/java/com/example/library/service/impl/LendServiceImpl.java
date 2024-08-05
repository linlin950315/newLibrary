package com.example.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.mapper.BookMapper;
import com.example.library.mapper.LendMapper;
import com.example.library.pojo.entity.Book;
import com.example.library.pojo.entity.Lend;
import com.example.library.service.LendService;

@Service
@Transactional
public class LendServiceImpl implements LendService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private LendMapper lendMapper;

    // TODO 先判断是否可借书
    // 获取图书id的集合

    // 可借书
    // 更变书的数量
    // 将该图书ID、读者编号插入到数据库中的借书表中
    @Override
    public void addlend(int book_id, int student_id) {

        Book book = bookMapper.getById(book_id);// select * from book where book_id = #{book_id}
        // TODO不能借重复的书
        if (book.getBook_id().equals(studentMakpper.getBookIdByStudentId(student_id))) {
            System.out.println("------------The book has already been borrowed out.--------------");
            // return;

        }
        if (book.getCounts() == 0) {
            System.out.println("------------The book has already been borrowed out.--------------");
            // return;
        } else {
            Lend lend = new Lend();
            lend.setStudentId(student_id);
            lend.setBookId(book_id);
            // 书数量-1
            bookMapper.decrementBookCount(book_id);
            // 记录借书数据
            lendMapper.createLoan(lend);

        }
    }
}