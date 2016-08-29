package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 存储过程p_dir_info的实体bean
 * @author Miller
 *
 */
public class DirInfo {

	private String user;
	private String path;
	private String parentPath;
	private String dir;
	private Date createTime;
	private String time;//返回格式化createTime属性后的日期字符串
	private int count;
	private long size;
	
	public String getTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(createTime);
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getParentPath() {
		return parentPath;
	}
	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	
	
	
}
