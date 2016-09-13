package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.AdminDao;

import com.model.User;

/*
 * 后台用户登录Action
 */
public class Login {

	/**
	 * 页面中是这样写的index.jsp
	 * <s:form action="admin" id="login" theme="simple">
	 * <s:submit type="image" src="images/dl.gif" id="id_log" method="adminLogin">
	 * 表示调用的是admin的adminLogin方法
	 */
	// 管理员登录
	public String adminLogin() {
		//获取用户名和密码
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		if(AdminDao.login(name, password))
		{
			return "success";// 成功跳转到 /admin/adminindex.jsp
		}else {
			return "loginerror"; //失败跳转到 /admin/loginerror.jsp
		}
	
	}

	
	public String exit(){ 
		return "exit"; //退出 /admin/index.jsp
	}
}
