package com.example.library.service;

import java.util.List;

import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Book;
import com.example.library.pojo.entity.Student;
import com.example.library.util.Result;

public interface StudentService {
    // C
    Student insertStudent(StudentDTO studentDTO);

    // R get lend List
    List<Book> getLendListById(int student_id);

    // get student by ID
    Result<Student> getStudentById(int student_id);

    // R read all
    List<Student> readAllstudent();

}
