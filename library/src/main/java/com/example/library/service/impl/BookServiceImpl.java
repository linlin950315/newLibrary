package com.example.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.mapper.BookMapper;
import com.example.library.pojo.dto.BookDTO;
import com.example.library.pojo.entity.Book;
import com.example.library.pojo.vo.BookVO;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookRepository bookRepository;

    // C
    @Override
    public BookVO insert(BookDTO bookDTO) {
        BookVO newbook = new BookVO();
        BeanUtils.copyProperties(bookDTO, newbook);
        System.out.println("BookServiceImpl: ------------Calling bookMapper.insert(book)-----------");
        System.out.println("Inserting BookVO.newbook:" + newbook);
        bookMapper.insert(newbook);
        return newbook;
    }

    @Override
    public int insertBookBatch(List<BookDTO> bookDTOList) {
        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOList) {
            Book book = new Book();
            BeanUtils.copyProperties(bookDTO, book);
            books.add(book);  // 加入到books集合中
        }
        return bookMapper.insertBookBatch(books);
    }

    // D
    @Override
    
    public void deleteById(int book_id) {
        System.out.println("Deleting book with id:" + book_id);
        System.out.println("------");
        bookMapper.deleteById(book_id);
    }

    // R
    @Override
    public Page<Book> readAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }
    @Override
    // public Page<Book> readAllsortBybookNameAsc(int page, int size) {
    //     // 创建分页对象，按 book_name 升序排序
    //     Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "book_name"));
    //     return bookRepository.findAll(pageable);
    // }
    
    public Page<Book> readAllsortBybookName(int page, int size, String sortBy, String descOrAsc) {
        // 判断排序方向（默认升序）
        Sort.Direction sortDirection = "desc".equalsIgnoreCase(descOrAsc) ? Sort.Direction.DESC : Sort.Direction.ASC;

        // 创建分页对象
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

        // 查询数据并返回
        return bookRepository.findAll(pageable);
    }
    
    @Override
    public Book findByBookId(int bookId) {
        return bookRepository.findByBookId(bookId).orElse(null);
    }

    //Read by Category
    @Override
    public List<Book> findByCategoryId(Long categoryId) {
        return bookRepository.findAllByCategory_CategoryId(categoryId);
    }
    // Read bookname by ID
    @Override
    public <Result>Book getBookById(@Param("bookId") int book_id) {
             Book bookInfo = bookMapper.getBookById(book_id);
             System.out.println("----------name-----------" + bookInfo);
             return bookInfo;
    }

    // U
    @Override
    public void updateBookInfo(BookDTO bookDTO) {
        BookVO bookvo = new BookVO();
        BeanUtils.copyProperties(bookDTO, bookvo);
        System.out.println("BookServiceImpl: ------------Calling bookMapper.update(book)-----------");
        System.out.println("Updating bookvo: " + bookvo);
        bookMapper.updateBookInfo(bookvo);
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
