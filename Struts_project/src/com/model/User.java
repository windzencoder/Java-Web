package com.model;
public class User implements java.io.Serializable {
	//id编号
	private Integer id;
	//num学号
	private String num;
	//password用户名
	private String password;
	//name密码
	private String name;
	
	public User() {
	}
	
	public User(String num, String password, String name) {
		this.num = num;
		this.password = password;
		this.name = name;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}