package com.wz.shopping.dao;

import java.util.List;

import com.wz.shopping.pojo.Goods;

/*
 * 商品接口
 */
public interface IGoods {
	
	//保存商品
	public void saveGoods(Goods goods);
	
	//查询商品 按商品名称
	public List<Goods> queryGoods(String gname);

}
