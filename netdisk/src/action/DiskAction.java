package action;

import service.interfaces.*;
public class DiskAction extends BaseAction
{
	private long diskSize;
	public long getDiskSize()
	{
		return diskSize;
	}
	public String execute() throws Exception
	{
		try
		{
			FileService fileService = serviceManager.getFileService();
			diskSize = fileService.getUserDiskSize(userInfo.getCookieUser());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return SUCCESS;
	}
}