package com.example.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.mapper.AuthorMapper;
import com.example.library.pojo.dto.AuthorDTO;
import com.example.library.pojo.entity.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private AuthorRepository authorRepository;

 @Override
    public int insertAuthor(List<AuthorDTO> authorDTOList) {
        System.out.println("-----authorDTOList = " + authorDTOList);
        List<Author> authors = new ArrayList<>();
        for (AuthorDTO authorDTO : authorDTOList) {
            Author author = new Author();
            BeanUtils.copyProperties(authorDTO, author);
            authors.add(author);  // 加入到authors集合中
        }
        return authorMapper.insertAuthor(authors);
    }

    @Override
    @Transactional //它能保证方法内多个数据库操作要么同时成功、要么同时失败
    public List<Author> addAuthors(List<String> authorNames) {
        //TODO若authorNames已存在，则直接返回，否则批量插入
        
         List<Author> authors = authorNames.stream()
         .map(Author::new) // 创建 Author 对象，ID 设为 null（自动增长）
         .collect(Collectors.toList());
        return authorRepository.saveAll(authors); // 📌 一次性批量插入
    }
}