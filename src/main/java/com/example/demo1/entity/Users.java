package com.example.demo1.entity;

import java.util.List;

public class Users {
    private Integer id;
    private String username;
    private String password;
    private String data;
    private String email;
    private  String phone;
    private String role_name;
    private List<Auth> roleList;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Auth> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Auth> roleList) {
        this.roleList = roleList;
    }

    public String getCredentialsSalt() {
        return this.username + this.password;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", data='" + data + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roleName='" + role_name + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
