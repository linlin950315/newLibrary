package com.example.library.pojo.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

//@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Author implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
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
    @JsonIgnore // 多对多 防止序列化递归 要是不加，不会堆栈溢出。但加入作者之后，以前存好的会丢失
    private Set<Book> books;
}
