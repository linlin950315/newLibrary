package com.example.library.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    // 名称
    private String name;

    // 分类id
    private Long categoryId;

    // 价格
    private BigDecimal price;

    // 图片
    private String image;

    // 描述信息
    private String description;

    // 0 已出租 1 可租
    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createUser;

    private Long updateUser;
}
