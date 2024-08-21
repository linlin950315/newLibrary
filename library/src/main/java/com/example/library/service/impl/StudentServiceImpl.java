package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.exception.ApiRequestException;
import com.example.library.mapper.StudentMapper;
import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Student;
import com.example.library.pojo.vo.LendVO;
import com.example.library.service.StudentService;
import com.example.library.util.Result;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    // Create
    @Override
    public Student insertStudent(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        studentMapper.insertStudent(student);
        // return List.of(student);
        return student;

    }

    // R1 get lend List
    @Override
    public List<LendVO> getLendListById(int student_id) {
        // test if student is already
        if (studentMapper.getStudentById(student_id) == null) {
            throw new ApiRequestException("student_id is not exist");
        }

        List<LendVO> studentInfo = studentMapper.getLendListById(student_id);
        // System.out.println("----------借书数量-----------" + studentInfo);
        return studentInfo;
    }

    // R2 get student by ID
    public Result<Student> getStudentById(int student_id) {
        Student studentInfo3 = studentMapper.getStudentById(student_id); // "SELECT * FROM student WHERE
                                                                         // student_id = #{student_id}"
        if (student_id < 0) {
            throw new ApiRequestException("student_id < 0 is not allowed");
        }

        // if (studentInfo3 == null) {
        // return Result.error("------null-----");
        // }

        return Result.success(studentInfo3);
    }

    // R read all
    public List<Student> readAllstudent() {
        return studentMapper.readAllstudent();

    }

}
