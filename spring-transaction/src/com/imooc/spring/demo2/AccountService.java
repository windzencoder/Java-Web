package com.imooc.spring.demo2;

/**
 * 转账案例的业务层接口
 * @author Miller
 *
 */
public interface AccountService {

	/**
	 * @param out 转出账号
	 * @param in 转入账号
	 * @param money 转账金额
	 */
	public void transfer(String out, String in, double money);
	
}
