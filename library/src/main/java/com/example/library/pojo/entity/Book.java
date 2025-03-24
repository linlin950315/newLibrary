package com.example.library.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data //get set方法
@SuperBuilder
@NoArgsConstructor//无参构造函数
@AllArgsConstructor//全参数构造函数
@Entity//?
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "book_id") // 映射数据库的 book_id
    private int bookId;

    // 名称
    @Column(name = "book_name") // 映射数据库的 book_id
    //private String book_name;
     private String bookName;
    // 分类id
    //private Long category_id;

    // 价格
    private BigDecimal price;

    // 图片
    private String image;

    // 描述信息
    private String description;
    // 总数量
    private Integer counts;

    // 0 已出租 1 可租
    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createUser;

    private Long updateUser;

  @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;


}
