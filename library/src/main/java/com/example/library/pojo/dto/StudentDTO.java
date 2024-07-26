package com.example.library.pojo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int student_id;

    // 名称
    private String student_name;

    // 分类id
    private Long studentId;

    // 0 不可租 1 可租
    private Integer status;

    private Long createUser;

    private Long updateUser;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
