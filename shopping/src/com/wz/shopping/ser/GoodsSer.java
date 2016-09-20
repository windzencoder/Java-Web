package com.wz.shopping.ser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.shopping.dao.IGoods;
import com.wz.shopping.impl.GoodsImpl;
import com.wz.shopping.pojo.Account;
import com.wz.shopping.pojo.Category;
import com.wz.shopping.pojo.Goods;

/**
 * 商品Servlet
 */
@WebServlet("/GoodsSer")
public class GoodsSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IGoods goodsImpl = new GoodsImpl();
	
    public GoodsSer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		if (status.equals("saveCategory")) {
			//添加商品
			Goods goods = new Goods();
			goods.setGname(request.getParameter("gname"));
			goods.setGprice(Double.parseDouble(request.getParameter("gprice")));
			goods.setGpic(request.getParameter("gpic"));
			goods.setGremark(request.getParameter("gremark"));
			goods.setGxremark(request.getParameter("gxremark"));
			goods.setGiscommend(Boolean.parseBoolean(request.getParameter("giscommend")));
			goods.setGisopen(Boolean.parseBoolean(request.getParameter("gisopen")));
			goods.setCid(Integer.parseInt(request.getParameter("cid")));//类别id
			
			//插入数据
			goodsImpl.saveGoods(goods);
			//跳转
			response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
		} 
	}

}
