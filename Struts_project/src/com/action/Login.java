package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.AdminDao;

import com.model.User;

/*
 * 后台用户登录Action
 */
public class Login {

	// 管理员登录
	public String adminLogin() {
		//获取用户名和密码
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		if(AdminDao.login(name, password))
		{
			return "success";
		}else {
			return "loginerror";
		}
	
	}

	
	public String exit(){
		return "exit";
	}
}
