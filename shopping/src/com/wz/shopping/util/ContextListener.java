package com.wz.shopping.util;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.wz.shopping.impl.CategoryImpl;

public class ContextListener implements ServletContextListener {

	private CategoryImpl categoryImpl=new CategoryImpl();
	
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}	

	public void contextInitialized(ServletContextEvent event) {
		//取出商品的类别 保存在application中
		event.getServletContext().setAttribute("categorys",categoryImpl.queryCategory(""));
		//启动时查询出最多4个热点类别
		
	}

}
