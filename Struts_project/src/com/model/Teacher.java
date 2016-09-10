package com.model;

public class Teacher implements java.io.Serializable {
	//id����
	private Integer id;
	//name����
	private String name;
	//sex����
	private String sex;
	//degree����
	private String degree;
	//position����
	private String position;
	//eduBackground����
	private String eduBackground;
	//college����
	private String college;
	//address����
	private String address;
	//direction����
	private String direction;
	//intro����
	private String intro;
	//achievement����
	private String achievement;
	//photo����
	private String photo;
	/**Ĭ�Ϲ��캯�� */
	public Teacher() {
	}
	/** ���캯�� */
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