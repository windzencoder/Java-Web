package com.wz.service;

import java.util.List;

import com.wz.entity.User;

public interface UserService {

	//添加用户
	void saveUser(User user);
	//按用户名查找用户
	User getUser(String name);
	//删除用户
	void deleteUser(int id);
	//更新用户
	void updateUser(User user);
	//按id查找用户
	User findUserById(int id);
	//查找全部用户
	List<User> findAll();
	
}
