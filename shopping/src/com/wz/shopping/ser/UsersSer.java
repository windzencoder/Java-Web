package com.wz.shopping.ser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.shopping.dao.IUsers;
import com.wz.shopping.impl.UsersImpl;
import com.wz.shopping.pojo.Fordor;
import com.wz.shopping.pojo.Users;


@WebServlet("/UsersSer")
public class UsersSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUsers usersImpl = new UsersImpl();

    public UsersSer() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String status = request.getParameter("status");
		if (status.equals("login")) {//登录
			Users users = new Users();
			users.setUlogin(request.getParameter("ulogin"));
			users.setUpass(request.getParameter("upass"));
			users=usersImpl.queryUser(users);
			if (users == null) {//登录失败
				request.setAttribute("error", "用户名或密码错误");
				request.getRequestDispatcher("/ulogin.jsp").forward(request, response);
				
			}else{
				//创建一个购物车 方便以后购物 把购物车放入session中
				Fordor fordor = new Fordor();
				request.getSession().setAttribute("forder", fordor);
				
				
				request.getSession().setAttribute("users", users);
				if(request.getSession().getAttribute("goUrl") != null){
					//说明用户登录成功后要跳转的页面
					response.sendRedirect(request.getSession().getAttribute("goUrl").toString());
				}else{//首页
					response.sendRedirect(request.getContextPath()+"/index.jsp");
				}
				
			}
		}
		
	}

}
