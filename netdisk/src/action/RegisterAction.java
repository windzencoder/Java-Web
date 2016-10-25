package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import service.interfaces.*;
import entity.*;

/**
 * 注册Action
 * @author Miller
 *
 */
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
				this.addFieldError("validationCode", "��֤���������!");
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
            //建立新用户对应的本地硬盘目录，用于保存上传后的文件
            if(!dir.exists()){
                dir.mkdir();
            }
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