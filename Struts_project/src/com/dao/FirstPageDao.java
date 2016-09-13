package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.Firstpage;
import com.model.HibernateSessionFactory;

/*
 * 首页管理Dao
 */
public class FirstPageDao {
	
	//获取首页课程描述
	public static String getFirstPageContent()
	{
		Session session = HibernateSessionFactory.getSession();
		String content=new String();
		try {
			session.beginTransaction();

			Firstpage firstpage=(Firstpage)session.get(Firstpage.class, 1);
			content=firstpage.getDescription();
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
		return content;
	}
	
	/*
	 * 通过id获取首页
	 */
	static public Firstpage getFirstpageById(int id) {
		Session session = HibernateSessionFactory.getSession();
		Firstpage firstpage = new Firstpage();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Firstpage.class);
			criteria.add(Restrictions.eq("id", id));
			List list = criteria.list();
			if (!list.isEmpty())
				firstpage = (Firstpage) list.get(0);
			else{
				firstpage.setDescription("没有首页");
				session.save(firstpage);
			}
			session.getTransaction().commit();
			return firstpage;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return firstpage;
	}
	
	public static void updateFirstPage(Firstpage firstpage)
	{
		Session session = HibernateSessionFactory.getSession();
		String content=new String();
		try {
			session.beginTransaction();

			session.update(firstpage);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	
	}
}
