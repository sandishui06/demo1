package com.example.demo1.config;

import com.example.demo1.entity.Users;
import com.example.demo1.service.ShiroService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wxx on 2019/5/9.
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private ShiroService shiroService;

    /**
     * 处理授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        return null;
    }

    /**
     * 处理认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 1.从token里面获取用户名
        String username = (String) token.getPrincipal();

        String password = new String((char[])token.getCredentials());
        // 2.从数据库查找该用户名，若失败，则抛异常
        Users user = shiroService.queryUserByUsername(username);
        if (user == null) {
            return null;
        }
        // 3.查询成功则验证数据
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );
        return authenticationInfo;
    }
}
