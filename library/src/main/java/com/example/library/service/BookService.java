package com.example.library.service;

import java.util.List;

import com.example.library.pojo.dto.BookDTO;
import com.example.library.pojo.entity.Book;

public interface BookService {
    // C
    List<Book> insertBook(BookDTO bookDTO);

    // D
    void deleteBook(int book_id);

    // R
    List<Book> getBookList();

    // U
    List<Book> updateBook(BookDTO bookDTO);

}
