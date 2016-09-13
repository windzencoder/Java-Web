package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.model.HibernateSessionFactory;
import com.model.Teacher;

/*
 * 教师管理Dao
 */
public class TeacherDao {
	
	//获取教师信息
	public static Teacher getTeacher()
	{
		Session session = HibernateSessionFactory.getSession();
		List<Teacher> list = new ArrayList<Teacher>();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Teacher.class);
			criteria.addOrder(Order.asc("id"));
			list = (List<Teacher>) criteria.list();
			session.getTransaction().commit();
			if(list.size()>0)
				return list.get(0);
			else {
				Teacher teacher=new Teacher();
				session.save(teacher);
				teacher=(Teacher)session.get(Teacher.class, 1);
				session.clear();
				return teacher;
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		
	}
	static public void InsertTeacher(Teacher teacher) {// ��ӽ�ʦ
		Session session = HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			
			session.update(teacher);
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}
	}
//	public static  Teacher GetTeacherList() { // ��ý�ʦ�б����
//		// TODO Auto-generated method stub
//		Session session = HibernateSessionFactory.getSession();
//		List<Teacher> list = new ArrayList<Teacher>();
//		try {
//			session.beginTransaction();
//			Criteria criteria = session.createCriteria(Teacher.class);
//			criteria.addOrder(Order.asc("id"));
//			list = (List<Teacher>) criteria.list();
//			session.getTransaction().commit();
//			if(list.size()>0)
//				return list.get(0);
//			else {
//				return null;
//			}
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//			return null;
//		} finally {
//			session.close();
//		}
//
//	}
}
