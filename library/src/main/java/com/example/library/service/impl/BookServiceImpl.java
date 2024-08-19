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
    public void insert(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        bookMapper.insert(book);
    }

    // D
    public void deleteById(int book_id) {
        System.out.println("Deleting book with id:" + book_id);
        System.out.println("------");
        bookMapper.deleteById(book_id);
    }

    // R
    public List<Book> readAll() {
        return bookMapper.readAll();
    }

    // Read by ID
    public Book checkLendListById(int book_id) {
        Book bookInfo = bookMapper.checkLendListById(book_id);
        System.out.println("----------name-----------" + bookInfo);
        return bookInfo;
    }

    // U
    public void updateBookInfo(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        System.out.println("BookServiceImpl: ------------Calling bookMapper.update(book)-----------");
        bookMapper.updateBookInfo(book);
    }

    // U counts-1
    // public void borrowABook(Book book) {
    // // 取得单本书的counts数
    // book.getCounts();
    // System.out.println("book2 counts: " + book.getCounts());
    // Book book2 = bookMapper.getById(book.getBook_id());
    // // System.out.println("book2: " + book);
    // // System.out.println("book2: " + book.getBook_id());
    // // System.out.println(book2);
    // // 若counts为0，则无法借出
    // if (book.getCounts() == 0) {
    // System.out.println("The book has already been borrowed out.");
    // return;
    // }
    // // 借出一本
    // bookMapper.borrowA(book);
    // // 剩余数量-1
    // book.setCounts(book.getCounts() - 1);
    // // 再次更新counts
    // bookMapper.update(book);
    // System.out.println("Borrow successfully.");

    // }

    // // U counts+1
    // public void returnABook(Book book) {

    // }
}