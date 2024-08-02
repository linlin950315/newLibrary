package com.example.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.library.pojo.entity.Lend;

@Mapper
public interface LendMapper {

    @Insert("INSERT INTO lend (bookId, studentId) VALUES (#{bookId}, #{studentId})")
    void createLoan(Lend lend);
}
