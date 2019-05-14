package com.example.demo1.entity;

/**
 * Created by wxx on 2019/5/10.
 */
public class RoleAuth {
    private Integer role_id;
    private  Integer auth_id;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
    }

    @Override
    public String toString() {
        return "RoleAuth{" +
                "role_id=" + role_id +
                ", auth_id=" + auth_id +
                '}';
    }
}
