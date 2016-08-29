package com.imooc.spring.demo2;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String out, String in, double money) {
		accountDao.outMoney(out, money);
		int i = 1 / 0;
		accountDao.inMoney(in, money);
	}

}
