package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.exception.ApiRequestException;
import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Student;
import com.example.library.pojo.vo.StudentVO;
import com.example.library.service.StudentService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/admin/student")
@Api(tags = "--------------STUDENT--------------")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /*
     * C
     */
    @PostMapping()
    public void insertAStudent(@RequestBody StudentDTO studentDTO) { // 注解@RequestBody用于接收前端传递给后端的、JSON对象的字符串
        studentService.insertStudent(studentDTO);
    }

    /**
     * R get lend List
     * http://localhost:8080/admin/student/1
     */
    @GetMapping("/{student_id}")
    public List<Student> getLendListById(@PathVariable("student_id") int student_id) {
        List<Student> studentInfo1 = studentService.getLendListById(student_id);
        return studentInfo1;
    }

    /**
     * R
     * get student by ID
     * http://localhost:8080/admin/student/search/6
     */
    @GetMapping("/search/{student_id}")
    public List<StudentVO> getStudentById(@PathVariable("student_id") int student_id) {
        throw new ApiRequestException("-------cannot get student with custom exception----");
        // throw new IllegalStateException("--------cannot get student--------");
        // List<StudentVO> studentInfo2 = studentService.getStudentById(student_id);
        // return studentInfo2;
    }
}
