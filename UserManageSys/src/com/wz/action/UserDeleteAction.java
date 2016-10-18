package com.wz.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wz.service.UserService;


//删除用户信息
public class UserDeleteAction  extends ActionSupport{

	private UserService userService;

	private int id;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String execute() throws Exception {
		userService.deleteUser(id);
		return SUCCESS;
	}
	
}
