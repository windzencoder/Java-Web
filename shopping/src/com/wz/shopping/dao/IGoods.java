package com.wz.shopping.dao;

import java.util.List;

import com.wz.shopping.pojo.Goods;

/*
 * 商品接口
 */
public interface IGoods {
	
	//保存商品
	public void saveGoods(Goods goods);
	
	/**
	 * 查询热点商品	
	 * @param cid 类别信息
	 * @return Goods的列表
	 */
	public List<Goods> queryGiscommandGoods(int cid);

}
