package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.library.pojo.entity.Book;
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
    void insertStudent(Student student);

    /**
     * R get student by ID @Select("SELECT * FROM lend l LEFT JOIN book b ON
     * l.bookId = b.book_id WHERE l.studentId = #{studentId}")
     */
    List<Book> getLendListById(int student_id);

    // get student by ID
    @Select("SELECT * FROM student WHERE student_id = #{student_id}")
    Student getStudentById(int student_id);

    // R read all
    @Select("select * from student")
    List<Student> readAllstudent();
}
