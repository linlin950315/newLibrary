package com.example.library.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.pojo.entity.Book;


@Repository
//provides implementations for findAll methods that support pagination.
public interface BookRepository extends  JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);

}