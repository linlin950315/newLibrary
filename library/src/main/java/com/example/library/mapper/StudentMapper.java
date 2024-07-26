package com.example.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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

}
