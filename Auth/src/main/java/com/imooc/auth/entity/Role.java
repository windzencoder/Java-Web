package com.imooc.auth.entity;

import com.imooc.auth.common.BaseEntity;

import java.io.Serializable;

/**
 * 角色实体
 */
public class Role extends BaseEntity implements Serializable {

    private String name;
    private String functionIds;
    
	public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getFunctionIds() {
		return functionIds;
	}

	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}

    
}
