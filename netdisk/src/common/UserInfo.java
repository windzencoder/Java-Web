package common;

import java.io.File;

public class UserInfo {
	
	private String cookieUser;//封装Cookie中用户名的属性
	private String root;//封装网络硬盘的根目录（本地路径）的属性
	private String userRoot;//封装指定用户在网络硬盘的本地路径中的路径
	private String dir;
	private String parentPath;
	private String time;//封装格式化后的目录创建日期和时间

	/**
	 * time属性的getter方法
	 */
	public String getTime() {

		return time;
	}

	/**
	 * time属性的setter方法
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * dir属性的getter方法
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * dir属性的setter方法
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * parentPath属性的getter方法
	 */
	public String getParentPath() {
		return parentPath;
	}

	/**
	 * parentPath属性的setter方法
	 */
	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	/**
	 * cookieUser属性的getter方法
	 */
	public String getCookieUser() {
		return cookieUser;
	}

	/**
	 * cookieUser属性的setter方法
	 */
	public void setCookieUser(String cookieUser) {
		this.cookieUser = cookieUser;
	}

	/**
	 * root属性的getter方法
	 */
	public String getRoot() {
		return root;
	}

	/**
	 * root属性的setter方法
	 */
	public void setRoot(String root) {
		this.root = root;
	}

	/**
	 * userRoot属性的getter方法
	 */
	public String getUserRoot() {
		return userRoot;
	}

	/**
	 * userRoot属性的setter方法
	 */
	public void setUserRoot(String userRoot) {
		this.userRoot = userRoot;
	}

	//返回path路径对应于网路硬盘跟目录的本地路径
	public String getAbsolutePath(String path) {
		String absolutePath = userRoot + (File.separator.equals("\\") ? path.replaceAll("/", "\\\\") : path);
		return absolutePath;
	}
}
