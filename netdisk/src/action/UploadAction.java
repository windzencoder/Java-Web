package action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import com.opensymphony.xwork2.ModelDriven;
import common.UploadFile;
import service.interfaces.*;

public class UploadAction extends BaseAction implements ModelDriven<UploadFile>
{

    private UploadFile uploadFile = new UploadFile();
    
	public UploadFile getModel()
	{		
		return uploadFile;
	}

	public String execute() throws Exception
	{	
		try
		{
			uploadFile.setUserInfo(userInfo);
			FileService fileService = serviceManager.getFileService();
			fileService.addFiles(uploadFile);
			return SUCCESS;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return ERROR;
	}
}