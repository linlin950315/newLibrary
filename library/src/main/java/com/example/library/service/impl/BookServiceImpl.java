package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.mapper.BookMapper;
import com.example.library.pojo.dto.BookDTO;
import com.example.library.pojo.entity.Book;
import com.example.library.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    // C
    public void insertBook(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        bookMapper.insert(book);
    }

    // D
    public void deleteBook(int book_id) {
        System.out.println("Deleting book with id:" + book_id);
        System.out.println("------");
        bookMapper.delete(book_id);
    }

    // R
    public List<Book> getBookList() {
        bookMapper.readAll();
        // 2.设置书的状态

        return bookMapper.readAll();
    }

    // U
    public void updateBook(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        System.out.println("BookServiceImpl: ------------Calling bookMapper.update(book)-----------");
        bookMapper.update(book);
    }
}