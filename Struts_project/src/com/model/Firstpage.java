package com.model;

public class Firstpage implements java.io.Serializable {
	//id属性
	private Integer id;
	//description属性
	private String description;
	/** 默认构造函数 */
	public Firstpage() {
	}
	/** 构造函数 */
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