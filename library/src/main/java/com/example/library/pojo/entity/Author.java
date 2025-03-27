package com.example.library.pojo.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id",nullable = false)
    @Id
    private Long authorId;

    @Column(name = "author_name", nullable = false)
    private String authorName;
   //这里的注解构造函数没生效，所以手写了

    public Author(String authorName) {
        this.authorName = authorName;
    }

     // 与 Book 的多对多关系
     @ManyToMany(mappedBy = "authors")
     private Set<Book> books;
}
