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
    private UserDao userDao;


    @Override
    public void add(Users users) {
        this.userDao.usershow(users);
    }

    @Override
    public List<Users> queryshow() {
        return userDao.queryshow();
    }

    @Override
    public Users updateshow(Integer id) {
        return this.userDao.updateshow(id);
    }

    @Override
    public void update(Users users) {
        this.userDao.update(users);
    }

    @Override
    public void deleteId(Integer id) {
        this.userDao.deleteId(id);
    }
}
