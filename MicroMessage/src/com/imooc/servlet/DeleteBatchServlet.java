package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

/**
 * 批量删除控制层
 */
public class DeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接收页面的参数
		String[] ids = req.getParameterValues("id");
		
		MaintainService maintainService = new MaintainService();
		maintainService.deleteBatch(ids);

		//页面跳转到List.action
		req.getRequestDispatcher("/List.action").forward(req, resp);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
