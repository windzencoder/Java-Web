package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import javax.servlet.http.*;
import service.interfaces.*;
import entity.*;

public class LoginAction extends BaseAction implements ModelDriven<User>
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
				this.addFieldError("validationCode", "—È÷§¬Î ‰»Î¥ÌŒÛ!");
			}
		}
	}

	public String execute() throws Exception
	{
		try
		{
			UserService userService = serviceManager.getUserService();
          
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