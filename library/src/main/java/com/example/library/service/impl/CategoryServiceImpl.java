package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.mapper.CategoryMapper;
import com.example.library.pojo.entity.Category;
import com.example.library.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryMapper categoryMapper;
//get all category
@Override
public List<Category> getAllCategory() {
   return categoryMapper.getAllCategory();
}

}
