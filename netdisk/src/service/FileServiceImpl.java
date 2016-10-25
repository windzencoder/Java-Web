package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import common.MyFile;
import common.UploadFile;
import common.UserInfo;
import dao.interfaces.FileDAO;
import entity.File;
import service.interfaces.FileService;

public class FileServiceImpl implements FileService {

	private FileDAO fileDAO;
	//Spring注入
	public FileServiceImpl(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}
	
	//将一个文件保存在本地硬盘上
	private String saveFile(java.io.File uploadFile, String fn) throws Exception {
		java.io.File file = new java.io.File(fn);
		int index = 0;
		String fileName = file.getName();
		//检测上传文件名是否有重复，如果有重名文件，则修改上传文件的文件名
		while(file.exists()){
			int exIndex = fileName.lastIndexOf(".");
			//判断上传文件手否有扩展名
			if (exIndex > 0) {
				fn = fileName.substring(0, exIndex) + "(" + String.valueOf(index) + ")" +fileName.substring(exIndex);
			}else {
				fn = fileName + "(" + String.valueOf(index) + ")";
			}
			//产生新的文件名
			fn = file.getPath().substring(0, file.getPath().lastIndexOf(file.getName())) + fn;
			file  = new java.io.File(fn);
			index ++;
		}
		//通过OutputStream将文件写到本地硬盘上（每次写8K字节）
		FileOutputStream fos = new FileOutputStream(fn);
		InputStream is = new FileInputStream(uploadFile);
		byte[] buffer = new byte[8192];
		int count = 0;
		while((count =  is.read(buffer)) > 0) {
			fos.write(buffer, 0, count);
		}
		fos.close();
		is.close();
		//返回最终上传文件名
		return file.getName();
	}

	@Override
	public void addFiles(UploadFile uploadFile) throws Exception {
		int i = 0;
		//扫描上传的文件，并逐个处理这些文件
		for(java.io.File f : uploadFile.getUpload()){
			String currentPath = uploadFile.getUserInfo().getUserRoot() 
					+ (java.io.File.separator.equals("\\")?uploadFile.getUploadPath().replaceAll("/", "\\\\"):uploadFile.getUploadPath());
			//将上传文件保存在本地硬盘
			String fn = saveFile(f, currentPath+uploadFile.getUploadFileName().get(i));
			//建立entity.File对象
			File file = new File();
			file.setUser(uploadFile.getUserInfo().getCookieUser());
			file.setFile(new java.io.File(fn).getName());
			file.setPath(uploadFile.getUploadPath());
			file.setSize(f.length());
			file.setUploadTime(new Date());
			//持久化对象
			fileDAO.save(file);
			i ++;
		}
	}

	@Override
	public void deleteFile(UserInfo userInfo, String file) {
		//删除数据库中的文件记录
		fileDAO.delete(userInfo, file);
		//删除本地硬盘中的文件
		MyFile.deleteAny(userInfo.getAbsolutePath(file));
	}

	@Override
	public long getUserDiskSize(String username) {
		return fileDAO.getUserDiskSize(username);
	}

	@Override
	public List<File> getFiles(String username, String path) {
		return fileDAO.getFiles(username, path);
	}

}
