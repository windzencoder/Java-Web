package com.wz.shopping.pojo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/*
 * 主订单模型
 */
public class Fordor {

	private int fid;
	private Date fdate;
	private double ftotal;
	private String fname;
	private String fphone;
	private String fremark;
	private String femail;
	private String fpost;
	private Users users;//用户
	//子订单集合 存储购物项目
	private List<Sorder> sorders = new ArrayList<>();
	
	
	public Fordor() {
		
	}
	
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	public double getFtotal() {
		return ftotal;
	}
	public void setFtotal(double ftotal) {
		this.ftotal = ftotal;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFphone() {
		return fphone;
	}
	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
	public String getFremark() {
		return fremark;
	}
	public void setFremark(String fremark) {
		this.fremark = fremark;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFpost() {
		return fpost;
	}
	public void setFpost(String fpost) {
		this.fpost = fpost;
	}
	public List<Sorder> getSorders() {
		return sorders;
	}
	public void setSorders(List<Sorder> sorders) {
		this.sorders = sorders;
	}


	@Override
	public String toString() {
		return "Fordor [fid=" + fid + ", fdate=" + fdate + ", ftotal=" + ftotal + ", fname=" + fname + ", fphone="
				+ fphone + ", fremark=" + fremark + ", femail=" + femail + ", fpost=" + fpost + ", sorders=" + sorders
				+ "]";
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
	
}
