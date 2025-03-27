package com.example.library.pojo.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.Data;

@Data
// @NoArgsConstructor
// @AllArgsConstructor
public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
@Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_name", nullable = false)
    private String authorName;
}
