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

/*
 * admin页面过滤器
 */
public class AdminFilter implements Filter {

    public AdminFilter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//过滤admin页面
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getSession().getAttribute("account") == null) {
			request.setAttribute("error", "非法进入");
			request.getRequestDispatcher("/alogin.jsp").forward(request, response);;
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
