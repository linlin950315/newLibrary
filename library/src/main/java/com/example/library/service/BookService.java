package com.example.library.service;

import java.util.List;

import com.example.library.pojo.dto.BookDTO;
import com.example.library.pojo.entity.Book;

public interface BookService {
    // C
    void insertBook(BookDTO bookDTO);

    // D
    void deleteBook(int book_id);

    // R
    List<Book> getBookList();

    // U
    void updateBook(BookDTO bookDTO);

}
