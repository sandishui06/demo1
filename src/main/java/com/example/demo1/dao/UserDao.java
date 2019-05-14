package com.example.demo1.dao;

import com.example.demo1.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    List<Users> queryshow();
}
