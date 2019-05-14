package com.example.demo1.service;

import com.example.demo1.entity.Auth;
import com.example.demo1.entity.RoleAuth;
import com.example.demo1.entity.Users;

import java.util.List;

/**
 * Created by wxx on 2019/5/9.
 */
public interface ShiroService {
    Users queryUserByUsername(String username);

    List<RoleAuth> queryAuthIdByRoleIdTwo(Integer id);// role_auth

    Auth queryAuthByauthid(Integer id);

    List<Auth> queryAuthBypid(Integer id);

    List<Auth> queryAuthBypidTwo(Integer pid);
}
