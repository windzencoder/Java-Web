package com.muke.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.entity.Department;
import com.muke.employee.entity.PageBean;
import com.muke.employee.service.DepartmentService;

/**
 * 部门管理业务层
 * @author Miller
 *
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	/**
	 * 分页查询部分的方法
	 */
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean =  new PageBean<Department>();
		pageBean.setCurrPage(currPage);//封装当前的页数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);//封装每页显示记录数
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num =  Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	//保存部门
	@Override
	public void save(Department department) {
		departmentDao.save(department);
	}
	//编辑部门
	@Override
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}
	
	//修改部门
	@Override
	public void update(Department department) {
		departmentDao.update(department);
	}
	
	//删除部门
	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
	}
	
	//查找所有的部门
	@Override
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}
	
}
