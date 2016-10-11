package com.wz.shopping.pojo;

import java.util.Date;

/*
 * 商品实体类
 */
public class Goods {

	private int gid;
	private String gname;
	private double gprice;
	private String gpic;
	//简单描述
	private String gremark;
	//详细描述
	private String gxremark;
	private Date gdate;
	//是否推荐
	private boolean giscommend;
	//是否有效
	private boolean gisopen;
	//商品所属类别
	private int cid;
	
	private Category category;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	public String getGpic() {
		return gpic;
	}
	public void setGpic(String gpic) {
		this.gpic = gpic;
	}
	public String getGremark() {
		return gremark;
	}
	public void setGremark(String gremark) {
		this.gremark = gremark;
	}
	public String getGxremark() {
		return gxremark;
	}
	public void setGxremark(String gxremark) {
		this.gxremark = gxremark;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean isGiscommend() {
		return giscommend;
	}
	public void setGiscommend(boolean giscommend) {
		this.giscommend = giscommend;
	}
	public boolean isGisopen() {
		return gisopen;
	}
	public void setGisopen(boolean gisopen) {
		this.gisopen = gisopen;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}
