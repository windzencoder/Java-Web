package com.model;

/*
 * 参考书籍实体
 */
public class Book implements java.io.Serializable {
	//id编号
	private Integer id;
	//name参考书籍名称
	private String name;
	//path书籍图片路径
	private String path;
	//description描述
	private String description;
	
	public Book() {
	}
	
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