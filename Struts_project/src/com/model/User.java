package com.model;
public class User implements java.io.Serializable {
	//id����
	private Integer id;
	//num����
	private String num;
	//password����
	private String password;
	//name����
	private String name;
	/**Ĭ�Ϲ��캯��*/
	public User() {
	}
	/**���캯�� */
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