package com.muke.employee.action;

import java.util.List;

import com.muke.employee.entity.Department;
import com.muke.employee.entity.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction  extends ActionSupport implements ModelDriven<Department>{

	//模型驱动对象
	private Department department =  new Department();
	@Override
	public Department getModel() {
		return department;
	}
	
	//注入业务层
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	//当期页
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//提供一个查询的方法
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到编辑部门的方法
	public String saveUI() {
		return "saveUI";
	}
	
	//添加部门
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
	
	//编辑部门
	public String edit() {
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//修改部门
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}
	
	//删除部门
	public String delete() {
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	
}
