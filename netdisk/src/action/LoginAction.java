package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import javax.servlet.http.*;
import service.interfaces.*;
import entity.*;

/*
 * 用户登录的Action
 */
public class LoginAction extends BaseAction implements ModelDriven<User>
{
	private User user = new User();

	public User getModel()
	{
		return user;
	}

	//校验用户提交的验证码
	@Override
	public void validate()
	{
		//如果用户提交的验证码为空，直接返回
		if("".equals(user.getValidationCode())) return;
		Object obj = ActionContext.getContext().getSession().get(
				"validation_code");
		 
		String validationCode = (obj != null) ? obj.toString() : "";

		if (!validationCode.equalsIgnoreCase(user.getValidationCode()))
		{
			if (user.getValidationCode() != null)
			{				
				this.addFieldError("validationCode", "验证码输入错误!");
			}
		}
	}

	//处理用户请求的方法
	public String execute() throws Exception
	{
		try
		{
			//通过ServiceManager对象获取UserService对象实例
			UserService userService = serviceManager.getUserService();
			//校验登录用户是否合法
			if(userService.verifyUser(user))
			{
				saveCookie("user", user.getUser(), 24 * 60 * 60);
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUser());
				session.setMaxInactiveInterval(60 * 60 * 3);
 			    return SUCCESS;
			}
		}
		catch (Exception e)
		{
		}
		return ERROR;
	}
}