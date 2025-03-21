package com.example.library.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.library.pojo.dto.BookDTO;
import com.example.library.pojo.entity.Book;
import com.example.library.pojo.vo.BookVO;

public interface BookService {
    // C
    BookVO insert(BookDTO bookDTO);
    
    int insertBookBatch(List<BookDTO> bookDTO);

    // D
    void deleteById(int book_id);

    // R
    Page<Book> readAll(int page, int size);

   // 根据bookName升序排序，分页查询所有书籍
   //Page<Book> readAllsortBybookNameAsc(int page, int size);
   Page<Book> readAllsortBy(int page, int size, String sortBy, String descOrAsc);
    
   // Read by Category
    List<Book> findByCategoryId(Long categoryId);

    // Read by ID
    <Result>Book getBookById(int book_id);
    Book findByBookId(int bookId);

    // U
    void updateBookInfo(BookDTO bookDTO);


    // // Update 借书 数量-1
    // void borrowABook(Book book);

    // // 还书 数量+1
    // void returnABook(Book book);

}
