package com.example.library.pojo.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO implements Serializable {
    private static final long serialVersionUID = 1L;

    // id
    public int student_id;

    // 名称
    private String student_name;

}
