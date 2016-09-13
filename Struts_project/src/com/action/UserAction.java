package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.UserDao;
import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 用户管理
 */
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/*
	 * 登录方法
	 */
	public String login() throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		if(no.isEmpty()||pwd.isEmpty())
		{
			return ERROR;// /user/loginerror.jsp
		}else {
			User  user=UserDao.isLogin(no, pwd);
			if(user==null)
			{
				return ERROR;
			}else {
				
				//保存到页面
				context.put("user", user);
				
				return SUCCESS; // /user/loginsuccess.jsp
			}			
		}		
	}
	
	/*
	 * 删除用户
	 */
	public String delUser()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		//删除用户
		UserDao.deleteUser(Integer.parseInt(id));
		
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		
		return "user";
		
	}
	
	
	/*
	 * 添加用户 跳转的页面
	 */
	public String toAddUser()throws Exception{
		return "toAddUser";
	}
	
	/*
	 * 添加用户 操作
	 */
	public String addUser()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String num=request.getParameter("num");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		//添加用户
		UserDao.addUser(num, name, pwd);
		//获取用户的列表
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		
		
		return "user";
	}
	
	/*
	 * 展示用户列表
	 */
	public String showUserList()throws Exception{
		ActionContext context=ActionContext.getContext();
		List<User> userList=UserDao.getUserList();
		//放入的是在request的
		context.put("userlist", userList);
		return "user";//返回的是/admin/userlist.jsp页面
	}

}
