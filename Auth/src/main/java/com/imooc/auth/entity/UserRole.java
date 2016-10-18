package com.imooc.auth.entity;

import com.imooc.auth.common.BaseEntity;

import java.io.Serializable;

/**
 * 用户角色实体
 */
public class UserRole extends BaseEntity implements Serializable {

    private Long userId;
    private Long roleId;

    public UserRole() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
