package com.example.demo1.entity;

import java.util.List;

/**
 * Created by wxx on 2019/5/9.
 */
public class Role {
    private Integer id;

    private String role_name;

    private List<Auth> authList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<Auth> getAuthList() {
        return authList;
    }

    public void setAuthList(List<Auth> authList) {
        this.authList = authList;
    }
}
