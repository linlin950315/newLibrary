package com.example.library.service;

import com.example.library.pojo.dto.BookDTO;

public interface BookService {
    /**
     * 新增book
     */
    void insertBook(BookDTO bookDTO);

}
