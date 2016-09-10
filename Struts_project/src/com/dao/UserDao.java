package com.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.HibernateSessionFactory;
import com.model.User;

public class UserDao {
	public static User isLogin(String no,String pwd)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(User.class);
			criteria.add(Restrictions.eq("num", no)).add(Restrictions.eq("password", pwd));
			List<User> users=criteria.list();
		
			session.close();
			if(users.isEmpty())
			{
				return null;
			}else {
				return users.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static void deleteUser(int id)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			User user=(User)session.get(User.class, id);
			session.delete(user);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void addUser(String num,String name, String pwd)
	{
		Session session=HibernateSessionFactory.getSession();
		User user=new User();
		user.setName(name);
		user.setNum(num);
		user.setPassword(pwd);
		try {
			
			
			session.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static List<User> getUserList()
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(User.class);
			
			List<User> users=criteria.list();
		
			session.close();
			return users;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
