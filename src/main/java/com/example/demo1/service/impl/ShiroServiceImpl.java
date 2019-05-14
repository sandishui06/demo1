package com.example.demo1.service.impl;

import com.example.demo1.dao.ShiroDao;
import com.example.demo1.entity.Auth;
import com.example.demo1.entity.Role;
import com.example.demo1.entity.RoleAuth;
import com.example.demo1.entity.Users;
import com.example.demo1.service.ShiroService;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxx on 2019/5/9.
 */
@Service
@Transactional
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    ShiroDao shiroDao;


    @Override
    public Users queryUserByUsername(String username) {  // 1.查询用户
        Users user = shiroDao.queryUserByUsername(username);

        if (user == null) {
            throw new UnknownAccountException();
        }
        // 2.查找用户对应的角色
        List<Role> roleList = new ArrayList<>();
        Integer role_id = shiroDao.queryRoleIdByUserId(user.getId());
        Role role = shiroDao.queryRoleByRoleId(role_id);
        // 3.查找角色对应的auth
        List<Integer> authIdList = shiroDao.queryAuthIdByRoleId(role.getId());
        List<Auth> authList = new ArrayList<>();
        for (Integer id:authIdList) {
            Auth auth = shiroDao.queryAuthByAuthId(id);
            authList.add(auth);
        }
        // 4.组装
        role.setAuthList(authList);
        roleList.add(role);
        return user;
    }

    @Override
    public List<RoleAuth> queryAuthIdByRoleIdTwo(Integer id) {
        return shiroDao.queryAuthIdByRoleIdTwo(id);
    }

    @Override
    public Auth queryAuthByauthid(Integer id) {
        return shiroDao.queryAuthByauthid(id);
    }

    @Override
    public List<Auth> queryAuthBypid(Integer id) {
        return shiroDao.queryAuthBypid(id);
    }

    @Override
    public List<Auth> queryAuthBypidTwo(Integer pid) {
        return shiroDao.queryAuthBypidTwo(pid);
    }
}
