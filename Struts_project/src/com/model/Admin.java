package com.model;

/*
 * 管理员
 */
public class Admin implements java.io.Serializable {
	//管理员编号
	private Integer id;
	//管理员用户名
	private String name;
	//管理员密码
	private String pwd;
	
	public Admin() {
	}
	
	public Admin(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}