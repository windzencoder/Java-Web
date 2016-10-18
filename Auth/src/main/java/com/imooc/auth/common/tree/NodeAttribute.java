package com.imooc.auth.common.tree;

import java.io.Serializable;

/**
 * 主要是url，点到一个节点时，希望加载什么页面
 */
public class NodeAttribute implements Serializable {
    private Long id;
    private String url;

    public NodeAttribute(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
