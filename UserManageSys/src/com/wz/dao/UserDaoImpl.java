package com.wz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wz.entity.User;

public class UserDaoImpl implements UserDAO{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}
	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	} 
	
	//添加用户
	@Override
	public void save(User user) {
		getSession().save(user);
	}

	//按用户名查找用户
	@Override
	public User getUser(String name) {
		String hql = "form User u where u.name=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, name);
		List<User> users = query.list();
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	//删除用户
	@Override
	public void delete(int id) {
		getSession().delete(findById(id));
	}

	//更新用户
	@Override
	public void update(User user) {
		//a different object with the same identifier value was already associated with the session
		getSession().merge(user);
		getSession().update(user);
	}

	//按id查找用户
	@Override
	public User findById(int id) {
		User user = (User) getSession().get(User.class, id);
		return user;
	}

	//查找全部用户
	@Override
	public List<User> findAll() {
		String hql = "from User";
		Query query = getSession().createQuery(hql);
		List<User> users = query.list();
		return users;
	}

}
