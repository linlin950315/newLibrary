package com.example.library.pojo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.library.pojo.entity.Category;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int book_id;

    // 名称
    private String book_name;

    // 分类id
    //private Long category_id;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // 价格
    private BigDecimal price;

    // 描述信息
    private String description;

    // 总数量
    private Integer counts;

    // 0 不可租 1 可租
    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createUser;

    private Long updateUser;
}
