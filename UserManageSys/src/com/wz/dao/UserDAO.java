package com.wz.dao;

import java.util.List;

import com.wz.entity.User;

/**
 * UserDAO接口
 * @author Miller
 *
 */
public interface UserDAO {
	//添加用户
	void save(User user);
	//按用户名查找用户
	User getUser(String name);
	//删除用户
	void delete(int id);
	//更新用户
	void update(User user);
	//按id查找用户
	User findById(int id);
	//查找全部用户
	List<User> findAll();
	
}
