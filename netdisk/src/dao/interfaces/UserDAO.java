package dao.interfaces;

import entity.User;

public interface UserDAO {
	//持久化User对象
	public void save(User user);
	//判断指定用户是否存在
	public boolean exists(User user);
	//返回指定用户的经加密的密码字符串，如果用户不存在，则返回null
	public String getPasswordMD5(User user);
}
