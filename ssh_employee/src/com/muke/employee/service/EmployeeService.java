package com.muke.employee.service;

import com.muke.employee.entity.Employee;
import com.muke.employee.entity.PageBean;

/**
 * 员工管理接口
 * @author Miller
 *
 */
public interface EmployeeService {
	
	public Employee login(Employee employee);

	public PageBean<Employee> findByPage(Integer currPage);

	public void save(Employee employee);

	public Employee findById(Integer eid);

	public void update(Employee employee);

	public void delete(Employee employee);
	
}
