package com.wz.shopping.pojo;

/*
 * 类别实体
 */
public class Category {

	private int cid;
	private String ctype;
	//是否为热点 热点类别会显示首页
	private boolean chot;
	private Account account;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public boolean isChot() {
		return chot;
	}
	public void setChot(boolean chot) {
		this.chot = chot;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
