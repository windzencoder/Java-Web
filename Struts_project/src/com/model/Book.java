package com.model;



public class Book implements java.io.Serializable {
	//id����
	private Integer id;
	//name����
	private String name;
	//path����
	private String path;
	//description����
	private String description;
	/**Ĭ�Ϲ��캯��*/
	public Book() {
	}
	/** ���캯��*/
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