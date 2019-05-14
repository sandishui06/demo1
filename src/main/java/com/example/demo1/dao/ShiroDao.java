package com.example.demo1.dao;

import com.example.demo1.entity.Auth;
import com.example.demo1.entity.Role;
import com.example.demo1.entity.RoleAuth;
import com.example.demo1.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wxx on 2019/5/9.
 */
@Mapper
@Repository
public interface ShiroDao {
    List<Users> queryAllUsers();

    Users queryUserByUsername(String username);

    Integer queryRoleIdByUserId(Integer id);// user_role

    Role queryRoleByRoleId(Integer id);

    List<Integer> queryAuthIdByRoleId(Integer id);// role_auth

    Auth queryAuthByAuthId(Integer id);

    List<RoleAuth> queryAuthIdByRoleIdTwo(Integer id);// role_auth


    Auth queryAuthByauthid(Integer id);

    List<Auth> queryAuthBypid(Integer id);

    List<Auth> queryAuthBypidTwo(Integer pid);

}
