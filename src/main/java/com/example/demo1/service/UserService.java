package com.example.demo1.service;

import com.example.demo1.entity.Users;

import java.util.List;

public interface UserService {
    void add(Users users);

    List<Users> queryshow();

    Users updateshow(Integer id);

    void update(Users users);

    void deleteId(Integer id);
}
