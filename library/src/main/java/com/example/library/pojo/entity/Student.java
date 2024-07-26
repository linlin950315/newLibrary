package com.example.library.pojo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
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
