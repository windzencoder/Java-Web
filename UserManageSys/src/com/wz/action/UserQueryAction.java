package com.wz.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wz.entity.User;
import com.wz.service.UserService;

//用户查询
public class UserQueryAction extends ActionSupport {

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		List<User> userList = userService.findAll();
		//将所有用户存放在request范围内
		ServletActionContext.getRequest().setAttribute("userlist", userList);
		return SUCCESS;
	}
	
}
