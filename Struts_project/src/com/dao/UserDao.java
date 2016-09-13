package com.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.model.HibernateSessionFactory;
import com.model.User;

/*
 * 用户管理Dao
 */
public class UserDao {
	
	/*
	 * 登录
	 */
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
	
	/*
	 * 删除用户
	 */
	public static void deleteUser(int id)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			User user=(User)session.get(User.class, id);
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	/*
	 * 添加用户
	 */
	public static void addUser(String num,String name, String pwd)
	{
		Session session=HibernateSessionFactory.getSession();
		//需要创建Transaction
		Transaction tx = session.beginTransaction();
		
		User user=new User();
		user.setName(name);
		user.setNum(num);
		user.setPassword(pwd);
		try {
			
			session.save(user);
			tx.commit();//提交事务
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			tx.rollback();//回滚事务
			
		} finally {
			if (session != null) {
				HibernateSessionFactory.closeSession();
			}
		}
		
	}
	
	/*
	 * 获取用户列表
	 */
	public static List<User> getUserList()
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(User.class);
			
			List<User> users=criteria.list();
		
			return users;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null) {
				HibernateSessionFactory.closeSession();
			}
		}
		return null;
	}
}
