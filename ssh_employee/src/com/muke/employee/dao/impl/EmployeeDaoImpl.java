package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.entity.Employee;

/**
 * 员工Dao实现类
 * @author Miller
 *
 */

public class EmployeeDaoImpl implements EmployeeDao{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}
	//获取和当前线程绑定的session
	private Session getSession() {
	    return sessionFactory.getCurrentSession();
	}
	@Override
	/**
	 * Dao层根据用户名和密码查询用户的方法
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		System.out.println(employee);
		String hql = "from Employee where username = ? and password = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, employee.getUsername());
		query.setParameter(1, employee.getPassword());
		List<Employee> list = query.list();
		if (list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	//总数量
	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		Query query = getSession().createQuery(hql);
		List<Long> list = query.list();
		if (list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//分页查询
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.setFirstResult(begin);
		criteria.setMaxResults(pageSize);
		List<Employee> list = criteria.list();
		return list;
	}
	
	//保存员工
	@Override
	public void save(Employee employee) {
		getSession().save(employee);
	}
	
	//更具Id查询员工
	@Override
	public Employee findById(Integer eid) {
		
		return (Employee) getSession().get(Employee.class, eid);
	}
	
	//修改员工
	@Override
	public void update(Employee employee) {
		getSession().update(employee);
	}
	
	//删除员工
	@Override
	public void delete(Employee employee) {
		getSession().delete(employee);
	}
	
}
