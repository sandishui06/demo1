package com.example.demo1.controller;

import com.example.demo1.dao.UserDao;
import com.example.demo1.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class AdministratorController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/adminList")
    public String adminList(Model model){
        List<Users> list =userDao.queryshow();

        for (Users users : list) {
            System.out.println(users);
        }
        model.addAttribute("list",list);
        return "admin-list";
    }
}
