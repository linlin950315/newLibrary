package com.example.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.mapper.BookMapper;
import com.example.library.mapper.LendMapper;
import com.example.library.pojo.entity.Book;
import com.example.library.pojo.entity.Lend;
import com.example.library.service.LendService;
import com.example.library.util.Result;

@Service
@Transactional
public class LendServiceImpl implements LendService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private LendMapper lendMapper;

    @Override
    public Result<Lend> lendAbook(int book_id, int student_id) {
        // 查输入的studentId和bookId是否在数据库中
        int targetCount = lendMapper.searchHistory(book_id, student_id);
        if (targetCount > 0) {
            System.out.println("------------不能借重复的书--------------");
            return Result.error("不能借重复的书");// ok
        }

        Book targetBook = bookMapper.checkLendListById(book_id); // ("select * from book where book_id = #{book_id}")
        if (targetBook.getCounts() == 0) {
            return Result.error("已借完"); // ok
        } else {
            Lend lend = new Lend();
            lend.setStudentId(student_id);
            lend.setBookId(book_id);
            // 书数量-1
            bookMapper.decrementBookCount(book_id);
            // 记录借书数据
            lendMapper.lendAbook(lend);
            return Result.success();// ok
        }

    }

}
