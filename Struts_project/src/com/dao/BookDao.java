package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.model.Book;
import com.model.HibernateSessionFactory;

public class BookDao {
	
	public static List<Book> GetBookList() {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		List<Book> list ;
		try {
			session.beginTransaction();
		
			Criteria criteria = session.createCriteria(Book.class);
			criteria.addOrder(Order.asc("id"));
			list = (List<Book>) criteria.list();
			session.getTransaction().commit();
		
			return list;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}
	public static Book  getBook(int id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			Book book=(Book)session.get(Book.class, id);
			session.getTransaction().commit();
			return book;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		return null;
	}
	public static Book  deleteBook(int id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			Book book=(Book)session.get(Book.class, id);
		
			session.delete(book);
			session.getTransaction().commit();
			return book;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		return null;
	}
	
	
	public static void  updatebook(Book book) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			session.update(book);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		
	}
	public static void  savebook(Book book) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			session.save(book);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		
	}

}
