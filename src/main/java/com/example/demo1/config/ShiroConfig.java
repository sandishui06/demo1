package com.example.demo1.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxx on 2019/5/9.
 */
@Configuration
public class ShiroConfig {

    //将自己的验证方式加入容器
    @Bean("myShiroRealm")
    public MyShiroRealm myRealm() {
        MyShiroRealm myRealm = new MyShiroRealm();
        return myRealm;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //必须为这个实现类
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = null;
        try {
            shiroFilterFactoryBean = new ShiroFilterFactoryBean();
            //设置安全管理器
            shiroFilterFactoryBean.setSecurityManager(securityManager);
            Map map = new HashMap();
            //Filter工厂，设置对应的过滤条件和跳转条件
            //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
            map.put("/loginOut", "logout");   //退出路径
            //登录
            map.put("/static/**", "anon");
            map.put("/templates", "anon");
            map.put("/css/**", "anon");
            map.put("/images/**", "anon");
            map.put("/js/**", "anon");
            map.put("/lib/**", "anon");
            map.put("/login/**", "anon"); //对登录路径放行，否则登录成功无法跳转
            map.put("/**", "authc");
            // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
            shiroFilterFactoryBean.setLoginUrl("/shiro");  //设置跳转的路径


            // 登录成功后要跳转的链接
            shiroFilterFactoryBean.setSuccessUrl("/tiao.do");

            // 设置无权限时跳转的 url;
            shiroFilterFactoryBean.setUnauthorizedUrl("/403");
            //对所有用户认证  这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
            shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

            return shiroFilterFactoryBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shiroFilterFactoryBean;
    }
    //启用shrio授权注解拦截方式，AOP式方法级权限检查
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
