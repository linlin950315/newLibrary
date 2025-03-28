package com.example.library.pojo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookAuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long authorId;

    private List<Long> bookIds;
}
