package com.wz.action;

import java.util.Iterator;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import com.opensymphony.xwork2.ActionSupport;
import com.wz.entity.User;
import com.wz.service.UserService;

//用户登录
public class LoginAction extends ActionSupport {

	//用户名
	private String username;
	//密码
	private String password;
	//用户类型
	private String usertype;
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		List<User> list = userService.findAll();
		User u = new User();
		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			u = (User) it.next();
			if (username.trim().equals(u.getName()) 
				&& password.trim().equals(u.getPassword())
				&& usertype.trim().equals(u.getType())) {
				return SUCCESS;
			}else {
				return "failer";
			}
		}
		return "failer";
	}
	
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
	
}
