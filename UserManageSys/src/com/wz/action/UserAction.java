package com.wz.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wz.entity.User;
import com.wz.service.UserService;

//添加用户
public class UserAction extends ActionSupport{

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private User user;
	
	@Override
	public String execute() throws Exception {
		User u = new User();
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setType(user.getType());
		userService.saveUser(u);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
