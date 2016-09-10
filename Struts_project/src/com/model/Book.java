package com.model;



public class Book implements java.io.Serializable {
	//id属性
	private Integer id;
	//name属性
	private String name;
	//path属性
	private String path;
	//description属性
	private String description;
	/**默认构造函数*/
	public Book() {
	}
	/** 构造函数*/
	public Book(String name, String path, String description) {
		this.name = name;
		this.path = path;
		this.description = description;
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}