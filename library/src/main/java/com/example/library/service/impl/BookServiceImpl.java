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
    @Override
    public void insertBook(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        bookMapper.insert(book);
    }

    // D
    public void deleteBook(String id) {
        System.out.println("Deleting book with id:" + id);
        System.out.println("------");
        bookMapper.delete(id);
    }

    // R
    public List<Book> getBookList() {
        return bookMapper.readAll();
    }
}