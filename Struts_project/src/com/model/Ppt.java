package com.model;


public class Ppt implements java.io.Serializable {
	//id编号
	private Integer id;
	//path ppt文件路径
	private String path;
	//name ppt文件名称
	private String name;
	//date 上传时间
	private String date;
	
	public Ppt() {
	}
	
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