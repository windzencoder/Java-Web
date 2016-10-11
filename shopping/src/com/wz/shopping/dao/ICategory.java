package com.wz.shopping.dao;

import java.util.List;

import com.wz.shopping.pojo.Category;

/*
 * 类别接口
 */
public interface ICategory {
	
	//保存类别
	public void saveCategory(Category category);
	
	//查询类别
	public List<Category> queryCategory(String ctype);
	
	//查询热点类别 最多4个 isHot是否是热点类别
	public List<Category> queryCategory(boolean isHot);
	
}
