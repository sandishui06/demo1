package com.example.demo1.controller;

import com.example.demo1.entity.Users;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class Test {
    @Autowired
    private UserService userService;


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/addUser")
    public String add(Users users){
        userService.add(users);
        return "ok";
    }

    @RequestMapping("/query")
    public String query(Model model){
        List<Users> list = userService.queryshow();
        model.addAttribute("list",list);
        return "index";
    }

    @RequestMapping("/update")
    public String update(Integer id,Model model){
        Users users=userService.updateshow(id);
        model.addAttribute("user",users);
        return "update";
    }

    @RequestMapping("/gitupdate")
    public String uppdate(Users users){
        userService.update(users);
        return "redirect:/query";
    }

    @RequestMapping("/delete")
    public String deleteid(Integer id){
        userService.deleteId(id);
        return "redirect:/query";
    }
}
