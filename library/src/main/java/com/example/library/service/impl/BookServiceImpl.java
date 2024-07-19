package com.example.library.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.mapper.BookMapper;
import com.example.library.pojo.dto.BookDTO;
import com.example.library.pojo.entity.Book;
import com.example.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void insertBook(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        bookMapper.insert(book);

    }
}