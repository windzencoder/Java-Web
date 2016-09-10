package com.model;

public class Teacher implements java.io.Serializable {
	//id属性
	private Integer id;
	//name属性
	private String name;
	//sex属性
	private String sex;
	//degree属性
	private String degree;
	//position属性
	private String position;
	//eduBackground属性
	private String eduBackground;
	//college属性
	private String college;
	//address属性
	private String address;
	//direction属性
	private String direction;
	//intro属性
	private String intro;
	//achievement属性
	private String achievement;
	//photo属性
	private String photo;
	/**默认构造函数 */
	public Teacher() {
	}
	/** 构造函数 */
	public Teacher(String name, String sex, String degree, String position,
			String eduBackground, String college, String address,
			String direction, String intro, String achievement, String photo) {
		this.name = name;
		this.sex = sex;
		this.degree = degree;
		this.position = position;
		this.eduBackground = eduBackground;
		this.college = college;
		this.address = address;
		this.direction = direction;
		this.intro = intro;
		this.achievement = achievement;
		this.photo = photo;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEduBackground() {
		return this.eduBackground;
	}

	public void setEduBackground(String eduBackground) {
		this.eduBackground = eduBackground;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAchievement() {
		return this.achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}