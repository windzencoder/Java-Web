package service;

import dao.interfaces.UserDAO;
import entity.User;
import service.interfaces.UserService;

public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	
	//构造方法，通过Spring注入
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void addUser(User user) throws Exception {
		if (userDAO.exists(user)) {
			throw new Exception("<"+user+">已经存在！");
		}else{
			userDAO.save(user);
		}
	}
	
	@Override
	public boolean verifyUser(User user) {
		String passwordMD5 = userDAO.getPasswordMD5(user);
		boolean result = false;
		try{
			result = (user.getPasswordMD5().equals(passwordMD5)) ? true : false;
		}catch(Exception e){
			
		}
		return result;
	}
	
}
