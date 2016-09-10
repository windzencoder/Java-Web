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
 * 
 */
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String login() throws Exception{
		//�õ�context
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		//ȡ�õ�¼ѧ��
		String no=request.getParameter("no");
		//��¼����
		String pwd=request.getParameter("pwd");
		//�Ƿ�Ϊ��
		if(no.isEmpty()||pwd.isEmpty())
		{
			return ERROR;
		}else {
			//�������ݿ�
			User  user=UserDao.isLogin(no, pwd);
			if(user==null)
			{
				return ERROR;
			}else {
				
				return SUCCESS;
			}			
		}		
	}
	public String delUser()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		UserDao.deleteUser(Integer.parseInt(id));
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		
		return "user";
		
	}
	public String toAddUser()throws Exception{
		return "toAddUser";
	}
	public String addUser()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String num=request.getParameter("num");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		UserDao.addUser(num, name, pwd);
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		
		
		return "user";
	}
	public String showUserList()throws Exception{
		ActionContext context=ActionContext.getContext();
	
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		
		
		return "user";
	}

}
