package com.example.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    //TODO
    @Override
    public List<Author> addAuthorsWithCheck(List<String> authorNames) {
// 1. 查询已存在的作者
        List<Author> existingAuthors = authorRepository.findByAuthorNameIn(authorNames);
        // 2. 提取已存在的作者名（转小写避免大小写问题）
        Set<String> existingNames = existingAuthors.stream()
                .map(a -> a.getAuthorName().toLowerCase())
                .collect(Collectors.toSet());
        System.out.println("----existingNames = " + existingNames);

        // 3. 过滤出新作者
        List<Author> newAuthors = authorNames.stream()
                .filter(name -> !existingNames.contains(name.toLowerCase()))
                .map(Author::new)
                .collect(Collectors.toList());
        System.out.println("-----newAuthors = " + newAuthors);

        // 4. 批量保存新作者
        if (!newAuthors.isEmpty()) {
            authorRepository.saveAll(newAuthors);
        }
// 5. 合并返回（已存在的 + 新插入的）
        List<Author> result = new ArrayList<>(existingAuthors);
        result.addAll(newAuthors);

        return result;

    }

}
