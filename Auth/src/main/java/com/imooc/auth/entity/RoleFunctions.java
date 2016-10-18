package com.imooc.auth.entity;

import com.imooc.auth.common.BaseEntity;

import java.io.Serializable;

/**
 * 角色功能实体
 */
public class RoleFunctions extends BaseEntity implements Serializable {

    private Long roleId;
    private Long functionId;
    private int status;

    public RoleFunctions() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
