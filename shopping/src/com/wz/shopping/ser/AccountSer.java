package com.wz.shopping.ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.shopping.dao.IAccount;
import com.wz.shopping.impl.AccountImpl;
import com.wz.shopping.pojo.Account;

@WebServlet(name="AccountSer",urlPatterns="/AccountSer")
public class AccountSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IAccount accountImpl = new AccountImpl();
       
    public AccountSer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		if (status.equals("login")) {
			Account account = new Account();
			account.setAlogin(request.getParameter("alogin"));
			account.setApass(request.getParameter("apass"));
			//查询客服人员
			account = accountImpl.queryAccount(account);
			if (account == null) {
				request.setAttribute("error", "对不起登录失败");
				request.getRequestDispatcher("/alogin.jsp").forward(request, response);
			}else{
				//保存到session 跳转到后台的页面
				request.getSession().setAttribute("account", account);
				response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
			}
		}
	}

}
