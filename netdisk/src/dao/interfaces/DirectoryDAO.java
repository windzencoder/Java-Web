package dao.interfaces;

import java.util.List;

import common.UserInfo;
import entity.DirInfo;
import entity.Directory;

public interface DirectoryDAO {

	//持久化Directory对象
	public void save(Directory directory);
	//删除目录信息
	public void delete(UserInfo userInfo, String path);
	//返回指定用户和路劲的所有子目录的信息
	public List<DirInfo> getDirInfo(String user, String parentPath);
	
}
