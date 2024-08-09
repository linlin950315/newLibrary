package com.example.library.service;

import java.util.List;

import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Student;
import com.example.library.pojo.vo.StudentVO;

public interface StudentService {
    // C
    List<Student> insertStudent(StudentDTO studentDTO);

    // Read by ID
    List<Student> getLendListById(int student_id);

    // get student by ID
    List<StudentVO> getStudentById(int student_id);

}
