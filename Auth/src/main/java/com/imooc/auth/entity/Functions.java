package com.imooc.auth.entity;

import com.imooc.auth.common.BaseEntity;

import java.io.Serializable;

/**
 * 功能实体
 */
public class Functions extends BaseEntity implements Serializable{

    private String name;
    private Long parentId;
    private String url;
    private int serialNum;
    private int accordion;

    public Functions() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getAccordion() {
        return accordion;
    }

    public void setAccordion(int accordion) {
        this.accordion = accordion;
    }
}
