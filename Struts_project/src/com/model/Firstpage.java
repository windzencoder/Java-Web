package com.model;

public class Firstpage implements java.io.Serializable {
	//id首页id
	private Integer id;
	//description首页描述
	private String description;
	
	public Firstpage() {
	}
	
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