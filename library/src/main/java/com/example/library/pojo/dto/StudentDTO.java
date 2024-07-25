package com.example.library.pojo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    // 名称
    private String name;

    // 分类id
    private Long categoryId;

    // 图片
    private String image;

    // 描述信息
    private String description;

    // 0 不可租 1 可租
    private Integer status;

    private Long createUser;

    private Long updateUser;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
