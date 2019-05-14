package com.example.demo1.controller;

import com.example.demo1.dao.ShiroDao;
import com.example.demo1.entity.Auth;
import com.example.demo1.entity.Users;
import com.example.demo1.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wxx on 2019/5/9.
 */
@Controller
public class ShiroController {

    @Autowired
    private ShiroDao shiroDao;
    @Autowired
    private ShiroService shiroService;

    @RequestMapping(value = "/shiro")
    public String gotoIndexPage() {
        return "login";
    }


    @RequestMapping(value = "/login")
    public String doLogin(HttpServletRequest request, Map<String, Object> map, Users users) {
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(users.getUsername(), users.getPassword());
            Subject subject = SecurityUtils.getSubject();
            //完成登录
            subject.login(usernamePasswordToken); //验证登录，如果异常 则走catch

            HttpSession session = request.getSession();
            session.setAttribute("list",users);  //创建session，把users存入，因为重定向无法传参
            return "redirect:/tiao.do";

        } catch (Exception e) {
            String ex = e.getClass().getName();
            if (ex != null) {
                if (UnknownAccountException.class.getName().equals(ex)) {
                    System.out.println("用户名不存在");
                    map.put("msg","用户名不存在");
                } else if (IncorrectCredentialsException.class.getName().equals(ex)) {
                    System.out.println("账户或密码错误");
                    map.put("msg","账户或密码错误");
                } else {
                    System.out.println("未知错误");
                }
            }
            //返回登录页面

            return "login";
        }
    }

    /**
     * 让账户是什么权限，就让他看到他可以看到的内容
     * 根据账号 查询到 usersId
     * 根据usersId 查询到 role_ID
     * 在根据role_ID 查询所对因的父Id
     * 根据父id查询所对应的子id  Pid
     * @param request
     * @param model
     * @return
     */

    @RequestMapping("/tiao.do")
    public String tiao(HttpServletRequest request,Model model){
        HttpSession   session   =   request.getSession();
        Users users = (Users) session.getAttribute("list"); //取出 存入session的账号密码

        Integer users1 =shiroDao.queryUserByUsername(users.getUsername()).getId(); //根据账号 查询到 usersId
        Integer role_id = shiroDao.queryRoleIdByUserId(users1);    //根据usersId 查询到 role_ID

        List<Auth> count =new ArrayList<>();

        List<Auth> list =shiroDao.queryAuthBypid(role_id); //根据 auth 菜单id 查询出所有的父id

        for (Auth auth : list) {
            List<Auth> listpid =shiroDao.queryAuthBypidTwo(auth.getId());  //根据 父id 查询 和父id相同的pid(子id)
            if(listpid!=null){
                auth.setAuths(listpid);
            }
            count.add(auth);
        }
        model.addAttribute("lists",count);

        return "index";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

}
