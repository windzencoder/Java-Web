package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

public class ShowReport extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Service service = new Service();
		List list = service.getProfit();
		req.getSession().setAttribute("PROFIT", list);
		req.getSession().setMaxInactiveInterval(60);//单位为秒

		
		resp.sendRedirect("index.jsp");
	}
	
}
