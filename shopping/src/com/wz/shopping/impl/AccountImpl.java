package com.wz.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wz.shopping.dao.IAccount;
import com.wz.shopping.pojo.Account;
import com.wz.shopping.util.DBConn;

//客服人员dao实现类
public class AccountImpl implements IAccount{

	/*
	 * 客服人员登录查询
	 */
	@Override
	public Account queryAccount(Account account) {
		
		Connection connection = null;
		connection = new DBConn().getConnection();
		
		Account temp = null;
		PreparedStatement ps = null;
		String sql = "select * from account where alogin=? and apass=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, account.getAlogin());
			ps.setString(2, account.getApass());
			ResultSet rs =  ps.executeQuery();
			if (rs.next()) {
				temp = new Account();
				temp.setAid(rs.getInt("aid"));
				temp.setAlogin(rs.getString("alogin"));
				temp.setAname(rs.getString("aname"));
				temp.setApass(rs.getString("apass"));
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
		
		return temp;
	}
	
}
