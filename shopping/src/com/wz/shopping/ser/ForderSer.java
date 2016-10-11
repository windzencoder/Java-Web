package com.wz.shopping.ser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.shopping.dao.IForder;
import com.wz.shopping.impl.IForderImpl;
import com.wz.shopping.pojo.Fordor;
import com.wz.shopping.pojo.Goods;
import com.wz.shopping.pojo.Sorder;
import com.wz.shopping.pojo.Users;

/**
 * 订单servlet
 */
@WebServlet("/ForderSer")
public class ForderSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IForder forderImpl = new IForderImpl();

    public ForderSer() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		if (status.equals("buy")) {
			
			//从sessoin中后去拿出购物车 把购物项添加到购物车中
			//然后再把forder重新放入session中
			Fordor fordor = (Fordor) request.getSession().getAttribute("forder");
			//购物项
			Sorder sorder = new Sorder();
			sorder.setSname(request.getParameter("gname"));//商品名称
			sorder.setSnumber(1);//商品数量
			sorder.setSprice(Double.valueOf(request.getParameter("gprice")));//商品价格
			//商品
			Goods goods = new Goods();
			goods.setGid(Integer.parseInt(request.getParameter("gid")));
			sorder.setGoods(goods);
			
			//把购物项添加到fordor
			//保存到session中
			request.getSession().setAttribute("forder", forderImpl.addSorder(fordor, sorder));
			
			System.out.println("-----------------------------");
			//跳转到购物车
			response.sendRedirect(request.getContextPath() +"/users/showCar.jsp");
			
		}else if(status.equals("deleteForder")){//清空购物车
			request.getSession().setAttribute("forder", new Fordor());
			response.sendRedirect(request.getContextPath() +"/users/showCar.jsp");
		}else if(status.equals("deleteSorder")){//删除购物项
			Fordor fordor = (Fordor) request.getSession().getAttribute("forder");
			int gid = Integer.parseInt(request.getParameter("gid"));
			request.getSession().setAttribute("forder", forderImpl.deleteSorder(fordor, gid));
			response.sendRedirect(request.getContextPath() +"/users/showCar.jsp");
		}else if(status.equals("saveForder")){//保存订单
			Fordor fordor = (Fordor) request.getSession().getAttribute("forder");
			fordor.setFname(request.getParameter("fname"));
			fordor.setFphone(request.getParameter("fphone"));
			fordor.setFemail(request.getParameter("femail"));
			fordor.setFpost(request.getParameter("fpost"));
			fordor.setFremark(request.getParameter("fremark"));
			//用户
			fordor.setUsers((Users)request.getSession().getAttribute("users"));
			forderImpl.saveForder(fordor);
		}

		
	}

}
