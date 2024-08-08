package com.example.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.library.pojo.entity.Lend;

@Mapper
public interface LendMapper {

    @Insert("INSERT INTO lend (bookId, studentId) VALUES (#{bookId}, #{studentId})")
    void lendAbook(Lend lend);

    // 查输入的studentId和bookId是否在数据库中
    @Select("select count(*) from lend l where bookId=#{book_id} and studentId=#{student_id}")
    int searchHistory(int book_id, int student_id);

}
