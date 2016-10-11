package com.wz.shopping.ser;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.shopping.dao.ICategory;
import com.wz.shopping.impl.CategoryImpl;
import com.wz.shopping.pojo.Account;
import com.wz.shopping.pojo.Category;

/**
 * 类别添加servlet
 */
@WebServlet("/CategorySer")
public class CategorySer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ICategory categoryImpl = new CategoryImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String status = req.getParameter("status");
		if (status.equals("saveCategory")) {
			Category category = new Category();
			category.setCtype(req.getParameter("ctype"));
			//注意转为boolean值
			category.setChot(Boolean.parseBoolean(req.getParameter("chot")));
			//客服人员
			category.setAccount((Account) req.getSession().getAttribute("account"));
			
			//插入数据
			categoryImpl.saveCategory(category);
			
			//即时更新 保存类别后 更新保存在application中的数据
			this.getServletContext().setAttribute("categorys", categoryImpl.queryCategory(""));
			
			//跳转
			resp.sendRedirect(req.getContextPath()+"/admin/main.jsp");
			
		} else if (status.equals("queryCategory")) {//查询类别
			String ctype = req.getParameter("ctype");
			List<Category> categories = categoryImpl.queryCategory(ctype);
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("/admin/queryCategory.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
