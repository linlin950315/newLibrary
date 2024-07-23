package com.example.library.service;

import com.example.library.pojo.dto.BookDTO;

public interface BookService {
    // C
    void insertBook(BookDTO bookDTO);

    // D
    void deleteBook(String id);

}
