package com.example.demo1.service.impl;

import com.example.demo1.dao.UserDao;
import com.example.demo1.entity.Users;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserService userService;



    @Override
    public List<Users> queryshow() {
        return userService.queryshow();
    }


}
