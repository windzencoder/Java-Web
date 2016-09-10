package com.wz.shopping.util;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.wz.shopping.impl.CategoryImpl;

public class ContextListener implements ServletContextListener {

	private CategoryImpl categoryImpl=new CategoryImpl();
	
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}	

	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute("categorys",categoryImpl.queryCategory(""));
	}

}
