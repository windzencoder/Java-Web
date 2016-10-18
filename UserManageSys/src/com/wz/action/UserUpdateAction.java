package com.wz.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wz.entity.User;
import com.wz.service.UserService;

//更新用户信息
public class UserUpdateAction extends ActionSupport {

	private UserService userService;
	private User user;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		if (userService.findUserById(user.getId()) != null) {
//			setUser(user);
			userService.updateUser(user);
			return SUCCESS;
		}
		addActionMessage(getText("error.message.not.exist"));
		return INPUT;
	}
	
	
}
