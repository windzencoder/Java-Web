package com.wz.shopping.ser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.shopping.pojo.Account;
import com.wz.shopping.pojo.Category;
import com.wz.shopping.pojo.Goods;

/**
 * 商品Servlet
 */
@WebServlet("/GoodsSer")
public class GoodsSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsSer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		if (status.equals("saveCategory")) {
			Goods goods = new Goods();
		} 
	}

}
