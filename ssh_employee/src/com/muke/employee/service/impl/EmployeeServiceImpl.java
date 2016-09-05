package com.muke.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.entity.Employee;
import com.muke.employee.entity.PageBean;
import com.muke.employee.service.EmployeeService;

/**
 * 员工业务层实现
 * @author Miller
 *
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	/**
	 * 业务层登录的方法
	 */
	public Employee login(Employee employee) {
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}
	
	//分页查询员工
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//分钟总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
		
	}
	
	//保存员工
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}
	
	//根据id查询员工
	@Override
	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
	}
	
	//修改员工
	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}
	
	//删除员工
	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}
	
}
