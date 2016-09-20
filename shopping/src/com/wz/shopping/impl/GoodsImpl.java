package com.wz.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.wz.shopping.dao.IGoods;
import com.wz.shopping.pojo.Goods;
import com.wz.shopping.util.DBConn;

/*
 * 商品操作实现类
 */
public class GoodsImpl implements IGoods{

	//保存商品
	@Override
	public void saveGoods(Goods goods) {
		Connection connection = null;
		connection = new DBConn().getConnection();

		PreparedStatement ps = null;
		String sql = "insert into goods(gname, gprice, gpic, gremark, gxremark, giscommend, gisopen, cid) " 
						+"values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, goods.getGname());
			ps.setDouble(2, goods.getGprice());
			ps.setString(3, goods.getGpic());
			
			ps.setString(4, goods.getGremark());
			ps.setString(5, goods.getGxremark());
			//日期处理 暂时先不处理
			//ps.setDate(6, new java.sql.Date(goods.getGdate().getTime()));
			
			ps.setBoolean(6, goods.isGiscommend());
			ps.setBoolean(7, goods.isGisopen());
			ps.setInt(8, goods.getCid());
			
		
			//更新
			ps.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭connection
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Goods> queryGoods(String gname) {
		return null;
	}

	
	
}
