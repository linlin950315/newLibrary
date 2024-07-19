package com.example.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.library.pojo.entity.Book;

@Mapper

public interface BookMapper {
    @Insert("insert into book(id)"
            +
            "values" +
            "(#{id})")
    void insert(Book book);

}
