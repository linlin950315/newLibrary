package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Student;
import com.example.library.service.StudentService;
import com.example.library.util.Result;

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
    public void insertStudent(@RequestBody StudentDTO studentDTO) { // 注解@RequestBody用于接收前端传递给后端的、JSON对象的字符串
        studentService.insertStudent(studentDTO);
    }

    /**
     * R get lend List
     */
    @GetMapping("/{student_id}")
    public Result<Student> getById(int student_id) {
        Student studentInfo = studentService.getLentListById(int student_id);
        return Result.success(studentInfo);
    }

}
