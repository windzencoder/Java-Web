package com.wz.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wz.shopping.dao.IForder;
import com.wz.shopping.dao.ISorder;
import com.wz.shopping.pojo.Fordor;
import com.wz.shopping.pojo.Sorder;
import com.wz.shopping.util.DBConn;

/*
 * 订单dao实现类
 */
public class IForderImpl implements IForder{

	private ISorder sorderImpl = new SorderImpl();
	
	@Override
	public Fordor addSorder(Fordor forder, Sorder sorder) {
		
		//找出重复项
		List<Sorder> sorders = forder.getSorders();
		int i = 0;
		for(; i <sorders.size(); i++ ){
			//商品编号相同
			if(sorders.get(i).getGoods().getGid() == sorder.getGoods().getGid()){
				break;
			}
		}
		if (i < sorders.size()) {//商品数量加1
			sorders.get(i).setSnumber(sorders.get(i).getSnumber()+1);
		}else{
			sorders.add(sorder);
		}
		forder.setSorders(sorders);
		
		//重新计算购物总价
		forder.setFtotal(this.calTotal(forder));
		
		return forder;
	}
	
	@Override
	public double calTotal(Fordor fordor) {//计算总价
		
		double total = 0.0;
		for(Sorder sorder : fordor.getSorders()){
			total = total+sorder.getSnumber()*sorder.getSprice();
		}
		
		return total;
	}

	//删除购物项
	@Override
	public Fordor deleteSorder(Fordor fordor, int gid) {
		
		List<Sorder> sorders = fordor.getSorders();
		for(int i=0; i<sorders.size(); i++){
			if (sorders.get(i).getGoods().getGid() == gid) {
				sorders.remove(i);
				break;
			}
		}
		//删除后的购物项集合放入到购物中
		fordor.setSorders(sorders);
		//计算总价
		fordor.setFtotal(this.calTotal(fordor));
		return fordor;
	}
	
	
	//插入主订单
	@Override
	public Fordor saveForder(Fordor forder) {
		
		ResultSet rs = null;
		Connection connection = null;
		connection = new DBConn().getConnection();
		
		int fid = 0;
		PreparedStatement ps = null;
		String sql = "insert into forder(ftotal, fname, fphone, fremark, femail, fpost, uid) values(?, ?, ?, ?,?, ?, ?)";
		try {
			
			//手动提交事务（事务的隔离性）
			connection.setAutoCommit(false);
			
			ps = connection.prepareStatement(sql);
			ps.setDouble(1, forder.getFtotal());
			ps.setString(2, forder.getFname());
			ps.setString(3, forder.getFphone());
			ps.setString(4, forder.getFremark());
			ps.setString(5, forder.getFemail());
			ps.setString(6, forder.getFpost());
			ps.setInt(7, forder.getUsers().getUid());//用户id
		
			ps.executeUpdate();
			
			//查询出插入订单的主键
			ps = connection.prepareStatement("select LAST_INSERT_ID() from forder");
			rs = ps.executeQuery();
			while(rs.next()){
				fid = rs.getInt(1);
			}
			
			//插入子订单项
			for (Sorder sorder : forder.getSorders()) {
				sorderImpl.saveSorder(sorder, fid, connection);
			}
			
			//提交 注意位置
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			
			//回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		} finally {
			//关闭connection
			if (connection != null) {
				try {
					//提交 关闭
					//connection.commit();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return forder;
	}
	
}











