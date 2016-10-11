package com.wz.shopping.pojo;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/*
 * 用户实体类
 */
public class Users {

	private int uid;
	private String ulogin;
	private String uname;
	private String upass;
	private String usex;
	private String upost;
	private String uemail;
	private String uphone;
	private String uaddress;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUlogin() {
		return ulogin;
	}
	public void setUlogin(String ulogin) {
		this.ulogin = ulogin;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUpost() {
		return upost;
	}
	public void setUpost(String upost) {
		this.upost = upost;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public Users(int uid, String ulogin, String uname, String upass, String usex, String upost, String uemail,
			String uaddress) {
		super();
		this.uid = uid;
		this.ulogin = ulogin;
		this.uname = uname;
		this.upass = upass;
		this.usex = usex;
		this.upost = upost;
		this.uemail = uemail;
		this.uaddress = uaddress;
	}
	
	public Users() {
	}
	
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", ulogin=" + ulogin + ", uname=" + uname + ", upass=" + upass + ", usex=" + usex
				+ ", upost=" + upost + ", uemail=" + uemail + ", uaddress=" + uaddress + "]";
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	
	
	
}
