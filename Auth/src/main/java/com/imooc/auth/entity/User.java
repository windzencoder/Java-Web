package com.imooc.auth.entity;

import com.imooc.auth.common.BaseEntity;

import java.io.Serializable;

/**
 * 用户实体
 */
public class User extends BaseEntity implements Serializable {

    private String name;
    private String pwd;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
