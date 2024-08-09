package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.mapper.StudentMapper;
import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Student;
import com.example.library.pojo.vo.StudentVO;
import com.example.library.service.StudentService;

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
    public List<Student> getLendListById(int student_id) {
        List<Student> studentInfo = studentMapper.getLendListById(student_id);
        System.out.println("----------借书数量-----------" + studentInfo.size());
        return studentInfo;
    }

    // get student by ID
    public List<StudentVO> getStudentById(int student_id) {
        // List<StudentVO> studentInfo3 = studentMapper.getStudentById(student_id);
        // 现在不用info3接收，直接return 右边的结果
        return studentMapper.getStudentById(student_id);
    }

}
