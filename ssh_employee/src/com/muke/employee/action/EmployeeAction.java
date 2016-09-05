package com.muke.employee.action;

import java.util.List;

import com.muke.employee.entity.Department;
import com.muke.employee.entity.Employee;
import com.muke.employee.entity.PageBean;
import com.muke.employee.service.DepartmentService;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 员工管理Action
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	//模型驱动
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	
	//业务层
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//部门管理类
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	//当前页
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * 登录执行方法
	 * @return
	 */
	public String login() {
		System.out.println("login方法执行了......");
		//调用业务层的类
		Employee existEmployee =  employeeService.login(employee);
		if (existEmployee == null) {
			//登录失败
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	
	}
	
	
	//分页查询员工的执行的方法
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到添加员工的页面
	public String saveUI() {
		//查询所有的部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		
		return "saveUI";
	}
	
	//保存员工
	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	//编辑员工
	public String edit() {
		//根据ID查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有的部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	//修改员工
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	//删除员工
	public String delete(){
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
	
}
