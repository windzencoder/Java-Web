package com.imooc.spring.demo3;

/**
 * 转账案例DAO层
 * @author Miller
 *
 */
public interface AccountDao {

	/**
	 * @param out 转出账号
	 * @param money
	 */
	public void outMoney(String out, double money);
	
	/**
	 * @param in 转入账号
	 * @param money
	 */
	public void inMoney(String in, double money);
	
}
