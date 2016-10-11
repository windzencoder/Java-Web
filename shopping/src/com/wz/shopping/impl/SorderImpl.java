package com.wz.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wz.shopping.dao.ISorder;
import com.wz.shopping.pojo.Sorder;


//子订单dao实现类
public class SorderImpl implements ISorder{

	@Override
	public void saveSorder(Sorder sorder, int fid, Connection connection) {
		String sql = "insert into sorder(sname, sprice, snumber, fid, gid) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, sorder.getSname());
			ps.setDouble(2, sorder.getSprice());
			ps.setInt(3, sorder.getSnumber());
			ps.setInt(4, fid);
			ps.setInt(5, sorder.getGoods().getGid());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			//回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			
		}
	}

}
