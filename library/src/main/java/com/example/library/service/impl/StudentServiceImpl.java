package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.exception.ApiRequestException;
import com.example.library.mapper.StudentMapper;
import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Lend;
import com.example.library.pojo.entity.Student;
import com.example.library.service.StudentService;
import com.example.library.util.Result;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    // Create
    @Override
    public List<Student> insertStudent(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        studentMapper.insertStudent(student);
        return null;
    }

    // Read by ID
    @Override
    public List<Lend> getLendListById(int student_id) {
        List<Lend> studentInfo = studentMapper.getLendListById(student_id);
        System.out.println("----------借书数量-----------" + studentInfo.size());
        return studentInfo;
    }

    // get student by ID
    public Result<Student> getStudentById(int student_id) {
        Student studentInfo3 = studentMapper.getStudentById(student_id); // "SELECT * FROM student WHERE
                                                                         // student_id = #{student_id}"
        if (student_id < 0) {
            throw new ApiRequestException("student_id < 0 is not allowed");
        }

        // if (studentInfo3.size() == 0) {
        // throw new ApiRequestException("Student with ID " + student_id + " is not
        // found.");
        // }

        return Result.success(studentInfo3);
    }

}
