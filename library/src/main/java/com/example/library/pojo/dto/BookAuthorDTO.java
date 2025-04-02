package com.example.library.pojo.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookAuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "author_id")
    private List<Long> authorIds;
    @Column(name = "book_id")
    private Long bookId;
}
