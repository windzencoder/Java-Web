package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import common.UserInfo;
import dao.interfaces.DirectoryDAO;
import dao.interfaces.FileDAO;
import entity.DirInfo;
import entity.Directory;
import service.interfaces.DirectoryService;

public class DirectoryServiceImpl implements DirectoryService{

	private DirectoryDAO directoryDAO;
	private FileDAO fileDAO;
	
	//spring注入
	public DirectoryServiceImpl(DirectoryDAO directoryDAO, FileDAO fileDAO) {
		super();
		this.directoryDAO = directoryDAO;
		this.fileDAO = fileDAO;
	}

	@Override
	public String addDirectory(UserInfo userInfo) throws Exception {
		//获取当前路径的本地目录
		String currentPath = userInfo.getUserRoot() + userInfo.getParentPath()+userInfo.getDir()+java.io.File.separator;
		currentPath = java.io.File.separator.equals("\\") ? currentPath.replaceAll("/", "\\\\") : currentPath;
		//创建Directory对象，并初始化其属性
		Directory directory = new Directory();
		directory.setUser(userInfo.getCookieUser());
		directory.setDir(userInfo.getDir());
		directory.setParentPath(userInfo.getParentPath());
		directory.setPath(userInfo.getParentPath() + userInfo.getDir() + "/");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//设置UserInfo对象的time属性值
		userInfo.setTime(dateFormat.format(date));
		directory.setCreateTime(date);
		
		directoryDAO.save(directory);
		
		java.io.File dir = new java.io.File(currentPath);
		//如果本地目录不村子，则创建这个目录
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return "成功创建目录";
	}

	@Override
	public void deleteDirectory(UserInfo userInfo, String path) {
		//删除t_directories表中的相关目录信息
		directoryDAO.delete(userInfo, path);
		//删除t_files表中在指定目录下的文件信息
		fileDAO.deleteFiles(userInfo, path);
		//删除本地硬盘中的相应问价和目录信息
		common.MyFile.deleteAny(userInfo.getAbsolutePath(path));
		
	}

	@Override
	public List<DirInfo> getDirInfo(String user, String parentPath) {
		return directoryDAO.getDirInfo(user, parentPath);
	}

}
