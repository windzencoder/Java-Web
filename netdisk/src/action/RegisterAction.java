package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import service.interfaces.*;
import entity.*;

public class RegisterAction extends BaseAction implements ModelDriven<User>
{
	private User user = new User();

	public User getModel()
	{
		return user;
	}

	@Override
	public void validate()
	{
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

	public String execute() throws Exception
	{
		try
		{
			UserService userService = serviceManager.getUserService();

			userService.addUser(user);
            File dir = new File(userInfo.getRoot() + user.getUser());
            if(!dir.exists())
                dir.mkdir();
			result = "<" + user.getUser() + ">注册成功！";
			return SUCCESS;
		}
		catch (Exception e)
		{
			result = e.getMessage();
			return ERROR;
		}

	}
}