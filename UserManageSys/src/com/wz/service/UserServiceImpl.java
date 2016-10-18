package com.wz.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wz.dao.UserDAO;
import com.wz.entity.User;

@Transactional
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	//提供UserDAO对象的注入通道
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	//添加用户
	@Override
	public void saveUser(User user) {
		if(userDAO.findById(user.getId()) == null){
			userDAO.save(user);
		}
	}

	//按用户名查找用户
	@Override
	public User getUser(String name) {
		return userDAO.getUser(name);
	}

	//删除用户
	@Override
	public void deleteUser(int id) {
		if (userDAO.findById(id) != null) {
			userDAO.delete(id);
		}
	}

	//更新用户
	@Override
	public void updateUser(User user) {
		if (userDAO.findById(user.getId()) != null) {
			userDAO.update(user);
		}
	}

	//按id查找用户
	@Override
	public User findUserById(int id) {
		return userDAO.findById(id);
	}

	//查找全部用户
	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

}
