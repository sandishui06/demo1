package com.example.demo1.dao;

import com.example.demo1.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    void usershow(Users users);

    List<Users> queryshow();

    Users updateshow(Integer id);

    void update(Users users);

    void deleteId(Integer id);
}
