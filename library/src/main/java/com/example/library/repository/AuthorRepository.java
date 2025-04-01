package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.pojo.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
// 查询已存在的作者

    List<Author> findByAuthorNameIn(List<String> authorNames);

}
