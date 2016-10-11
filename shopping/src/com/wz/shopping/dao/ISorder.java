package com.wz.shopping.dao;

import java.sql.Connection;

import com.wz.shopping.pojo.Sorder;

//子订单
public interface ISorder {

	//插入子订单
	public void saveSorder(Sorder sorder, int fid, Connection connection);
	
}
