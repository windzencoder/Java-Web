package com.wz.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wz.shopping.dao.ICategory;
import com.wz.shopping.pojo.Account;
import com.wz.shopping.pojo.Category;
import com.wz.shopping.util.DBConn;

public class CategoryImpl implements ICategory{

	//保存类别
	@Override
	public void saveCategory(Category category) {
		Connection connection = null;
		connection = new DBConn().getConnection();

		PreparedStatement ps = null;
		String sql = "insert into category(ctype, chot, aid) values(?, ?, ?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, category.getCtype());
			//注意是is开头的方法
			ps.setBoolean(2, category.isChot());
			//外键
			ps.setInt(3, category.getAccount().getAid());
			
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
	
	//查询类别
	@Override
	public List<Category> queryCategory(String ctype) {
		Connection connection = null;
		connection = new DBConn().getConnection();

		PreparedStatement ps = null;
		String sql = "select * from category c inner join account a on c.aid = a.aid  where ctype like ?";
		
		List<Category> categories = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "%" + ctype + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				category.setChot(rs.getBoolean("chot"));
				
				Account account = new Account();
				account.setAid(rs.getInt("aid"));
				account.setAname(rs.getString("aname"));
				category.setAccount(account);
				
				categories.add(category);
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
		return categories.size() == 0 ? null : categories;
	}
	
	//查询热点类别
	@Override
	public List<Integer> queryChotCategory() {
		return null;
	}
	
	
}
