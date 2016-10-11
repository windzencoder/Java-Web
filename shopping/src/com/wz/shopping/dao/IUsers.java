package com.wz.shopping.dao;

import com.wz.shopping.pojo.Users;

/**
 * 用户接口
 * @author Miller
 *
 */
public interface IUsers {

	//登录验证
	public Users queryUser(Users users);
	
}
