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
					// ɾ��Ŀ¼
					if (path.charAt(path.length() - 1) == '/')
					{												
						directoryService.deleteDirectory(userInfo, path);
					}
					//  ɾ���ļ�
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