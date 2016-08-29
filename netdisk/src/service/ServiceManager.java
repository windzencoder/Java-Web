package service;

import service.interfaces.DirectoryService;
import service.interfaces.FileService;
import service.interfaces.UserService;

public class ServiceManager {

	//通过Spring注入
	private UserService userService;
	private DirectoryService directoryService;
	private FileService fileService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public DirectoryService getDirectoryService() {
		return directoryService;
	}
	public void setDirectoryService(DirectoryService directoryService) {
		this.directoryService = directoryService;
	}
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	
	
}
