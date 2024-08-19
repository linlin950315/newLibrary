package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Book;
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
    public void insertAStudent(@RequestBody StudentDTO studentDTO) { // 注解@RequestBody用于接收前端传递给后端的、JSON对象的字符串
        studentService.insertStudent(studentDTO);
    }

    /**
     * R get lend List
     * http://localhost:8080/admin/student/get-lend-list/1
     */
    @GetMapping("/get-lend-list/{student_id}")
    public List<Book> getLendListById(@PathVariable("student_id") int student_id) {
        List<Book> studentInfo1 = studentService.getLendListById(student_id);

        return studentInfo1;
    }

    /**
     * R get student by ID
     * http://localhost:8080/admin/student/6
     */
    @GetMapping("/{student_id}")
    public Result<Student> getStudentById(@PathVariable("student_id") int student_id) {
        // throw new ApiRequestException("-------cannot get student with custom
        // exception----");
        // throw new IllegalStateException("--------cannot get student--------");
        Result<Student> studentInfo2 = studentService.getStudentById(student_id);
        return studentInfo2;
    }

    /**
     * Read all student
     */
    @GetMapping()
    public List<Student> readAllstudent() {
        return studentService.readAllstudent();
    }
}
