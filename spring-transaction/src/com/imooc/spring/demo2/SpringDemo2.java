package com.imooc.spring.demo2;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class SpringDemo2 {

	@Resource(name="accountServiceProxy")
	private AccountService accountService;
	
	@Test
	public void demo1() {
		accountService.transfer("aaa", "bbb", 200d);
	}

}
