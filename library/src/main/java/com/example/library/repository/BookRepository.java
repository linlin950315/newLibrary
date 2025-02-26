package com.example.library.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.pojo.entity.Book;


@Repository
//provides implementations for findAll methods that support pagination.
public interface BookRepository extends  JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);

    // Spring Data JPA 方法命名规则 简化 Service 层逻辑
    List<Book> findAllByCategory_CategoryId(Long categoryId);

    Optional<Book> findByBookId(int bookId);

}
