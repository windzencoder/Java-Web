package com.wz.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wz.shopping.dao.IUsers;
import com.wz.shopping.pojo.Users;
import com.wz.shopping.util.DBConn;

public class UsersImpl implements IUsers{

	//登录查询
	@Override
	public Users queryUser(Users users) {
		
		Connection connection = null;
		connection = new DBConn().getConnection();
		
		Users temp = null;
		PreparedStatement ps = null;
		String sql = "select * from users where ulogin=? and upass=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, users.getUlogin());
			ps.setString(2, users.getUpass());
			ResultSet rs =  ps.executeQuery();
			if (rs.next()) {
				temp = new Users();
				temp.setUid(rs.getInt("uid"));
				temp.setUlogin(rs.getString("ulogin"));
				temp.setUname(rs.getString("uname"));
				temp.setUpass(rs.getString("upass"));
				temp.setUemail(rs.getString("uemail"));
				temp.setUsex(rs.getString("usex"));
				temp.setUaddress(rs.getString("uaddress"));
				temp.setUpost(rs.getString("upost"));
				temp.setUphone(rs.getString("uphone"));
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
