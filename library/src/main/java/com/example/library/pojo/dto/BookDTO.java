package com.example.library.pojo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
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

    //private int book_id;
      @Column(name = "book_id") // 映射数据库的 book_id
    private int bookId;

    // 名称
    private String book_name;

    // 分类id
    private Long categoryId;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    //private Category category;
    // 获取分类ID
   
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
