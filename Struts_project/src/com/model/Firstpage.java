package com.model;

public class Firstpage implements java.io.Serializable {
	//id����
	private Integer id;
	//description����
	private String description;
	/** Ĭ�Ϲ��캯�� */
	public Firstpage() {
	}
	/** ���캯�� */
	public Firstpage(String description) {
		this.description = description;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}