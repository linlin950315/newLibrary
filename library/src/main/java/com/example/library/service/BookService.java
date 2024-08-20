package com.example.library.service;

import java.util.List;

import com.example.library.pojo.dto.BookDTO;
import com.example.library.pojo.entity.Book;

public interface BookService {
    // C
    Book insert(BookDTO bookDTO);

    // D
    void deleteById(int book_id);

    // R
    List<Book> readAll();

    // Read by ID
    Book checkLendListById(int book_id);

    // U
    void updateBookInfo(BookDTO bookDTO);

    // // Update 借书 数量-1
    // void borrowABook(Book book);

    // // 还书 数量+1
    // void returnABook(Book book);

}
