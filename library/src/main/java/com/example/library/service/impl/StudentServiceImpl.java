package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.mapper.StudentMapper;
import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Student;
import com.example.library.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> insertStudent(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        studentMapper.addStudent(student);
        return null;
    }

}
