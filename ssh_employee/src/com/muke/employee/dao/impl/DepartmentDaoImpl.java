package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.entity.Department;

/**
 * 部门管理Dao
 * @author Miller
 *
 */

public class DepartmentDaoImpl implements DepartmentDao{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}
	//获取和当前线程绑定的session
	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 统计个数
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Department";
		Query query = getSession().createQuery(hql);
		List<Long> list = query.list();
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * 分页查询部门
	 */
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		
		Criteria criteria = getSession().createCriteria(Department.class);
		criteria.setFirstResult(begin);
		criteria.setMaxResults(pageSize);
		List<Department> list = criteria.list();
		
		return list;
	}
	
	//保存部门
	@Override
	public void save(Department department) {
		getSession().save(department);
	}
	
	//编辑部门
	@Override
	public Department findById(Integer did) {
		return (Department)getSession().get(Department.class, did);
	}
	
	//修改部门
	@Override
	public void update(Department department) {
		getSession().update(department);
	}
	
	//删除部门
	@Override
	public void delete(Department department) {
		getSession().delete(department);
	}
	
	
	//查询所有部门
	@Override
	public List<Department> findAll() {
		String hql = "from Department";
		Query query = getSession().createQuery(hql);
		List<Department> list = query.list();
		
		return list;
	}
	
}
