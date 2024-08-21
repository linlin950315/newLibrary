package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.pojo.dto.StudentDTO;
import com.example.library.pojo.entity.Student;
import com.example.library.pojo.vo.LendVO;
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
    public int insertAStudent(@RequestBody StudentDTO studentDTO) { // 注解@RequestBody用于接收前端传递给后端的、JSON对象的字符串
        Student newStudent = studentService.insertStudent(studentDTO);
        return newStudent.getStudent_id();
    }

    /**
     * R1 get lend List
     * http://localhost:8080/admin/student/getlendlist/1
     */
    @GetMapping("/getlendlist/{student_id}")
    public List<LendVO> getLendListById(@PathVariable("student_id") int student_id) { // SELECT * FROM lend l LEFT JOIN
                                                                                      // book b ON l.bookId = b.book_id
                                                                                      // WHERE l.studentId =
                                                                                      // #{studentId}"
        List<LendVO> studentInfo1 = studentService.getLendListById(student_id);
        return studentInfo1;
    }

    /**
     * R2 get student by ID
     * http://localhost:8080/admin/student/1
     */
    @GetMapping("/{student_id}")
    public Result<Student> getStudentById(@PathVariable("student_id") int student_id, Model model) {
        // throw new ApiRequestException("-------cannot get student with custom
        // exception----");
        // throw new IllegalStateException("--------cannot get student--------");
        Result<Student> studentInfo = studentService.getStudentById(student_id);
        return studentInfo;
    }

    /**
     * R3 read all student
     */
    @GetMapping()
    public List<Student> readAllstudent() {
        return studentService.readAllstudent();
    }
}
