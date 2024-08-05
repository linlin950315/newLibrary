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

    // Read by ID
    Book getBookById(int book_id);

    // U
    void updateBook(BookDTO bookDTO);

    // // Update 借书 数量-1
    // void borrowABook(Book book);

    // // 还书 数量+1
    // void returnABook(Book book);

}
