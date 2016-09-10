package com.model;


public class Ppt implements java.io.Serializable {
	//id属性
	private Integer id;
	//path属性
	private String path;
	//name属性
	private String name;
	//date属性
	private String date;
	/** 默认构造函数 */
	public Ppt() {
	}
	/** 构造函数 */
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