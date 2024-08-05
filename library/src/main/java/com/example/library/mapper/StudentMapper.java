package com.example.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.library.pojo.entity.Student;

@Mapper
public interface StudentMapper {
    /**
     * C
     */
    @Insert("insert into student(student_id,student_name)"
            +
            "values" +
            "(#{student_id},#{student_name})")
    void addStudent(Student student);

    @Select("SELECT * FROM lend l LEFT JOIN book b ON l.bookId = b.book_id WHERE l.studentId = #{studentId}")
    Student getRentListById(int student_id);

}
