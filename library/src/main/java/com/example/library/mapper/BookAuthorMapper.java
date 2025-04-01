package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.library.pojo.dto.AuthorDTO;

@Mapper
public interface BookAuthorMapper {

    @Select("select a.author_id, a.author_name from book b inner join book_author ba ON b.book_id = ba.book_id inner join author a on a.author_id = ba.author_id where b.book_id = #{bookId}")
    @Results({
        @Result(property = "authorId", column = "author_id"),
        @Result(property = "authorName", column = "author_name")
    })
    List<AuthorDTO> getAuthorNamesByBookId(Long bookId);
}
