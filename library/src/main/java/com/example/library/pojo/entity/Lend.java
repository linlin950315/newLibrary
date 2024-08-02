package com.example.library.pojo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lend implements Serializable {
    private static final long serialVersionUID = 1L;

    private int lend_id;
    private int bookId;
    public int studentId;

}
