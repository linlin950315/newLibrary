package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.library.pojo.entity.Book;

@Mapper

public interface BookMapper {
    /**
     * C
     */
    @Insert("insert into book(id,name)"
            +
            "values" +
            "(#{id},#{name})")
    void insert(Book book);

    /**
     * D
     */
    @Delete("delete from book where id = #{id}")
    void delete(@Param("id") String id);

    /**
     * R
     */
    @Select("select * from book")
    List<Book> readAll();
}
