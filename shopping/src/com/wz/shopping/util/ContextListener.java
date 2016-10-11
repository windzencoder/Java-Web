package com.wz.shopping.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.wz.shopping.dao.ICategory;
import com.wz.shopping.dao.IGoods;
import com.wz.shopping.impl.CategoryImpl;
import com.wz.shopping.impl.GoodsImpl;
import com.wz.shopping.pojo.Category;
import com.wz.shopping.pojo.Goods;

public class ContextListener implements ServletContextListener {

	private ICategory categoryImpl=new CategoryImpl();
	private IGoods goodsImpl = new GoodsImpl();
	
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}	

	public void contextInitialized(ServletContextEvent event) {
		//取出商品的类别 保存在application中
		event.getServletContext().setAttribute("categorys",categoryImpl.queryCategory(""));
		
		//定时器 定时更新
		ShoppingTimerTask shoppingTimerTask =  new ShoppingTimerTask();
		shoppingTimerTask.setApplication(event.getServletContext());
		new Timer().schedule(shoppingTimerTask, 0, 1000*60*60*24);

		
	}

}
