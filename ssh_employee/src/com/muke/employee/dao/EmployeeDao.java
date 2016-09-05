package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.entity.Employee;

/**
 * 员工管理Dao接口
 * @author Miller
 *
 */
public interface EmployeeDao {

	public Employee findByUsernameAndPassword(Employee employee);

	public int findCount();

	public List<Employee> findByPage(int begin, int pageSize);

	public void save(Employee employee);

	public Employee findById(Integer eid);

	public void update(Employee employee);

	public void delete(Employee employee);

}
