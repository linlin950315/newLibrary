package com.example.library.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

//@Data 
@Getter
@Setter
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

    // 与 Author 的多对多关系
    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @JsonIgnoreProperties("books") // 防止序列化递归 要是不加，不会堆栈溢出。但加入作者之后，以前存好的会丢失
    private Set<Author> authors;

}
