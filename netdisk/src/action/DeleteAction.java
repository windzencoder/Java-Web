package action;

import service.interfaces.*;
public class DeleteAction extends BaseAction
{
    private String[] paths;

	public void setPaths(String paths)
	{
		this.paths = paths.split(";");
	}

	public String execute() throws Exception
	{
		try
		{
			DirectoryService directoryService = serviceManager.getDirectoryService();
			FileService fileService = serviceManager.getFileService();
			for (String path : paths)
			{
				if (path != null)
				{
					// É¾³ýÄ¿Â¼
					if (path.charAt(path.length() - 1) == '/')
					{												
						directoryService.deleteDirectory(userInfo, path);
					}
					//  É¾³ýÎÄ¼þ
					else
					{
						fileService.deleteFile(userInfo, path);
					}					
				}
			}		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
}