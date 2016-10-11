package com.wz.shopping.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户过滤器
 */
public class UsersFilter implements Filter {

    public UsersFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if(req.getSession().getAttribute("users") == null){
			//非法请求，自动跳转到登录页面
			req.setAttribute("error", "请先登录");
			//保存将要跳转的地址
			req.getSession().setAttribute("goUrl", req.getRequestURI()+"?"+req.getQueryString());
			
			req.getRequestDispatcher("/ulogin.jsp").forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
