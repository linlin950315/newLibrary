package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.library.pojo.entity.Author;
@Mapper
public interface AuthorMapper {
        // batch  .xml file
        int insertAuthor(@Param("list") List<Author> authors);
}
