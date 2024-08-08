package com.example.library.service;

import com.example.library.pojo.entity.Lend;
import com.example.library.util.Result;

public interface LendService {

    Result<Lend> lendAbook(int book_id, int student_id);

}
