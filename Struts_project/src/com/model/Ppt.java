package com.model;


public class Ppt implements java.io.Serializable {
	//id����
	private Integer id;
	//path����
	private String path;
	//name����
	private String name;
	//date����
	private String date;
	/** Ĭ�Ϲ��캯�� */
	public Ppt() {
	}
	/** ���캯�� */
	public Ppt(String path, String name, String date) {
		this.path = path;
		this.name = name;
		this.date = date;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}