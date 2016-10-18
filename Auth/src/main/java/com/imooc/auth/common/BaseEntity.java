package com.imooc.auth.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 实体类的基类
 */
public class BaseEntity {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //把id和实体对应起来
    public static <T extends BaseEntity> Map<Long,T> idEntityMap(Collection<T> list){
        Map<Long,T> map=new HashMap<>();

        if(null==list||0==list.size()){
            return map;
        }

        for(T entity:list){
            map.put(entity.getId(),entity);
        }
        return map;
    }
}
