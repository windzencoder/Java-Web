package com.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.Admin;
import com.model.HibernateSessionFactory;
import com.model.User;

/*
 * 后台用户管理Dao层
 */
public class AdminDao {
	
	public static boolean login(String name,String pwd)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(Admin.class);
			criteria.add(Restrictions.eq("name", name)).add(Restrictions.eq("pwd", pwd));
			List<Admin> admins=criteria.list();
			
			session.close();
			if(admins.isEmpty())
			{
				return false;
			}else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
