package com.example.library.service;

import java.util.List;

import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Student;
import com.example.library.pojo.vo.LendVO;
import com.example.library.util.Result;

public interface StudentService {
    // C
    Student insertStudent(StudentDTO studentDTO);

    // R1 get lend List
    List<LendVO> getLendListById(int student_id);

    // R2 get student by ID
    Result<Student> getStudentById(int student_id);

    // R3 read all
    List<Student> readAllstudent();

}
