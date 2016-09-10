package com.model;
public class Admin implements java.io.Serializable {
	//映射id
	private Integer id;
	//管理员name
	private String name;
	//管理员密码
	private String pwd;
	/** 默认构造函数 */
	public Admin() {
	}
	/** 构造函数 */
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