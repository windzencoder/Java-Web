package com.wz.shopping.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.apple.eawt.Application;
import com.wz.shopping.dao.ICategory;
import com.wz.shopping.dao.IGoods;
import com.wz.shopping.impl.CategoryImpl;
import com.wz.shopping.impl.GoodsImpl;
import com.wz.shopping.pojo.Category;
import com.wz.shopping.pojo.Goods;
//定时更新
public class ShoppingTimerTask extends TimerTask{

	private ICategory categoryImpl=new CategoryImpl();
	private IGoods goodsImpl = new GoodsImpl();
	private ServletContext application = null;
	
	@Override
	public void run() {
		
		System.out.println("定时器run......");
		
		//查询热点类别的推荐商品
		
		List<List<Goods>> bigList = new ArrayList<>();
		//启动时查询出最多4个热点类别
		for (Category category : categoryImpl.queryCategory(true)) {
			System.out.println("热点类别cid："+category.getCid());
			List<Goods> goods = goodsImpl.queryGiscommandGoods(category.getCid());
			System.out.println("商品列表："+goods);
			bigList.add(goods);
		} 
		//存到application中
		application.setAttribute("bigList", bigList);
		
	}

	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

}
