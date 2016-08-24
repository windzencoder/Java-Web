package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Profit;
import jdbc.JdbcConn;

public class Service {

	private Connection dbconnection;
	private Statement st ,st1, st2;
	private ResultSet rs ,rs1, rs2;
	private String sql;
	private List list;
	private Profit pf;
	
	public List getProfit() {
		list = new ArrayList();
		dbconnection = JdbcConn.getConnection();
		try {
			st = (Statement)dbconnection.createStatement();
			st1 = (Statement)dbconnection.createStatement();
			st2 = (Statement)dbconnection.createStatement();
			sql = "select g.goods_name goodsName, g.cost_price costPrice, g.selling_price  selling,g.goods_id goodsId "
					+"from goods g, trading t "
					+"where t.trading_goods_id = g.goods_id "
					+"group by g.goods_name";
			rs = st.executeQuery(sql);
			
			int temp;
			while(rs.next()){
				pf = new Profit();
				pf.setGoodsName(rs.getString("goodsName"));
				pf.setSellingPrice(rs.getInt("selling"));
				pf.setCostPrice(rs.getInt("costPrice"));
				pf.setGoodsId(rs.getInt("goodsId"));
				
				//单个利润
				temp = 0;
				temp = pf.getSellingPrice() - pf.getCostPrice();
				
				//取交易商品的数量
				sql = "select sum(t.trading_number) sumNum from trading t where t.trading_goods_id = "+pf.getGoodsId();
				rs1 = st1.executeQuery(sql);
				while(rs1.next()) {
					pf.setTradingNum(rs1.getInt("sumNum"));
				}
				
				//总利润
				pf.setProfit(temp * pf.getTradingNum());
				
				//取得交易次数
				sql = "select count(t.trading_id) times  from trading t where t.trading_goods_id ="+pf.getGoodsId();
				rs2 = st2.executeQuery(sql);
				while(rs2.next()){
					pf.setTimes(rs2.getInt("times"));
				}
				
				list.add(pf);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
