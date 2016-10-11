package com.wz.shopping.dao;

import com.wz.shopping.pojo.Fordor;
import com.wz.shopping.pojo.Sorder;
import com.wz.shopping.ser.ForderSer;

/*
 * 订单接口
 */
public interface IForder {
	
	//添加到购物车
	public Fordor addSorder(Fordor forder, Sorder sorder);
	
	//计算总价
	public double calTotal(Fordor fordor);
	
	//删除购物项
	public Fordor deleteSorder(Fordor fordor, int gid);
	
	//在数据库中插入主订单
	public Fordor saveForder(Fordor forder);
	
}
