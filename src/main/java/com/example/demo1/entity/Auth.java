package com.example.demo1.entity;

import java.util.List;

/**
 * Created by wxx on 2019/5/9.
 */
public class Auth {
    private Integer id;

    private String name;

    private String type;

    private String url;

    private Integer pid;

    private String iconfont;

    private List<Auth> auths;


    public String getIconfont() {
        return iconfont;
    }

    public void setIconfont(String iconfont) {
        this.iconfont = iconfont;
    }

    public List<Auth> getAuths() {
        return auths;
    }

    public void setAuths(List<Auth> auths) {
        this.auths = auths;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", auths=" + auths +
                '}';
    }
}
