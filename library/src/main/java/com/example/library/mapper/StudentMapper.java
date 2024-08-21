package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.library.pojo.entity.Student;
import com.example.library.pojo.vo.LendVO;

@Mapper
public interface StudentMapper {
    /**
     * C
     */
    @Insert("insert into student(student_id,student_name)"
            +
            "values" +
            "(#{student_id},#{student_name})")
    void insertStudent(Student student);

    /**
     * R1 get lend List
     * @Select("SELECT * FROM lend l LEFT JOIN book b ON
     * l.bookId = b.book_id WHERE l.studentId = #{studentId}")
     */
    List<LendVO> getLendListById(int student_id); // TODO 换其他的entity来收数据

    // get student by ID
    @Select("SELECT * FROM student WHERE student_id = #{student_id}")
    Student getStudentById(int student_id);

    // R read all
    @Select("select * from student")
    List<Student> readAllstudent();
}
