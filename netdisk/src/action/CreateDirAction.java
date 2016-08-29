package action;

import com.opensymphony.xwork2.ModelDriven;
import service.interfaces.*;
import common.*;

public class CreateDirAction extends BaseAction implements
		ModelDriven<UserInfo>
{
	public UserInfo getModel()
	{
		return userInfo;
	}
	public String execute() throws Exception
	{
		try
		{
			DirectoryService directoryService = serviceManager
					.getDirectoryService();
			setResult(directoryService.addDirectory(userInfo));
			return SUCCESS;
		}
		catch (Exception e)
		{
			setResult("½¨Á¢Ä¿Â¼Ê§°Ü");
		}
		return ERROR;
	}

}