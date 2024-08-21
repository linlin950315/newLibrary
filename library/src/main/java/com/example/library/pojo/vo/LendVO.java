package com.example.library.pojo.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LendVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int student_id;

    private String student_name;

    private int book_id;

    private String book_name;

    private Long categoryId;

    private String image;

    private String description;
    
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createUser;

    private Long updateUser;

}
