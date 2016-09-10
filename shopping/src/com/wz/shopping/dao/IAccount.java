package com.wz.shopping.dao;

import com.wz.shopping.pojo.Account;

/*
 * 客服人员接口
 */
public interface IAccount {

	//登录验证
	public Account queryAccount(Account account);
	
}
