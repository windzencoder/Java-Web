package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.FirstPageDao;

import com.model.Firstpage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 首页管理Action
 */
public class FirstPageAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	//默认方法 获取课程描述
	public String execute() throws Exception {
		ActionContext context=ActionContext.getContext();
		String content=FirstPageDao.getFirstPageContent();
		context.put("description", content);
		return SUCCESS;
	}
	
	/*
	 * 展示首页
	 */
	public static String adminShowFirstPage() {
		ActionContext context=ActionContext.getContext();
		//获取首页
		Firstpage firstpage=FirstPageDao.getFirstpageById(1);
		context.put("firstpage", firstpage);
		return "firstpage";
	}
	
	/*
	 * 修改首页
	 */
	public String modifyfirstpage() {

		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		//获取首页
		Firstpage firstpage = FirstPageDao.getFirstpageById(id);
		request.setAttribute("firstpage", firstpage);
		return "modifyfirstpage";
		
	}	
	public String saveFirstpage() throws Exception {
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request = ServletActionContext.getRequest();
		String content= request.getParameter("content");
		Firstpage firstpage = FirstPageDao.getFirstpageById(1);
		firstpage.setDescription(content);
		FirstPageDao.updateFirstPage(firstpage);
		context.put("firstpage", firstpage);
		return "firstpage";
	}
	
}
