package com.example.library.service;

import java.util.List;

import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Student;

public interface StudentService {
    // C
    List<Student> insertStudent(StudentDTO studentDTO);

    // Read by ID
    Student getLentListById();
}
