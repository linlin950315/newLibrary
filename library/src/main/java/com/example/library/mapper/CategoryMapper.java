package com.example.library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.library.pojo.entity.Category;

@Mapper
public interface CategoryMapper {
//get all category
@Select("SELECT * FROM category")
List<Category> getAllCategory();
}
