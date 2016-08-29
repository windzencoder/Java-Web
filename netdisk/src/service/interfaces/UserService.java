package service.interfaces;

import entity.User;

public interface UserService {

	//向数据库中添加用户
	public void addUser(User user) throws Exception;
	//校验登录用户是否合法
	public boolean verifyUser(User user);
	
}
