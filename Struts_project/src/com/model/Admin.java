package com.model;
public class Admin implements java.io.Serializable {
	//ӳ��id
	private Integer id;
	//����Աname
	private String name;
	//����Ա����
	private String pwd;
	/** Ĭ�Ϲ��캯�� */
	public Admin() {
	}
	/** ���캯�� */
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