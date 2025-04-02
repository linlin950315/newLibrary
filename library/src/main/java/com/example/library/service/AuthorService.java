package com.example.library.service;

import java.util.List;

import com.example.library.pojo.dto.AuthorDTO;
import com.example.library.pojo.entity.Author;

public interface AuthorService {

    int insertAuthor(List<AuthorDTO> authorDTO);

    List<Author> addAuthors(List<String> authorNames);

    List<Author> addAuthorsWithCheck(List<String> authorNames);

}
