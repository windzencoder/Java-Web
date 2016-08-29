package dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.interfaces.UserDAO;
import entity.User;

public class UserDAOImpl extends DAOSupport implements UserDAO  {

	//构造方法，通过DAOSupport类的构造器方法传入一个HibernateTemplate对象
	public UserDAOImpl(HibernateTemplate template) {
		super(template);
	}

	@Override
	public void save(User user) {
		template.save(user);
	}

	@Override
	public boolean exists(User user) {
		return (getPasswordMD5(user) != null) ? true:false;
	}

	@Override
	public String getPasswordMD5(User user) {
		String hql = "select passwordMD5 from User where user = ?";
		//使用find方法执行HQL语句，并查找指定的用户
		List<String> passwordMD5 = template.find(hql, user.getUser());
		//如果用户存在，则返回经过加密的密码字符串
		if (passwordMD5.size() > 0) {
			return passwordMD5.get(0);
		}
		return null;
	}

}
