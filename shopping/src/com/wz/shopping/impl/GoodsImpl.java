package com.wz.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.wz.shopping.dao.IGoods;
import com.wz.shopping.pojo.Category;
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


	//查询推荐的商品
	@Override
	public List<Goods> queryGiscommandGoods(int cid) {
		Connection connection = null;
		connection = new DBConn().getConnection();

		PreparedStatement ps = null;
		//布尔值不用加单引号
		String sql = "select * from goods g inner join category c on g.cid=c.cid where g.giscommend=true and g.gisopen=true and g.cid=? order by gdate desc";
		
		List<Goods> goodsList = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGid(rs.getInt("gid"));
				goods.setGname(rs.getString("gname"));
				goods.setGprice(rs.getDouble("gprice"));
				goods.setGpic(rs.getString("gpic"));
				goods.setGdate(rs.getDate("gdate"));
				goods.setGiscommend(rs.getBoolean("giscommend"));
				goods.setGisopen(rs.getBoolean("gisopen"));
				goods.setGremark(rs.getString("gremark"));
				goods.setGxremark(rs.getString("gxremark"));
				
				//类别
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				category.setChot(rs.getBoolean("chot"));
				
				goods.setCategory(category);
				
				
				goodsList.add(goods);
			}
			
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
		
		return goodsList;
	}
	
	
}
