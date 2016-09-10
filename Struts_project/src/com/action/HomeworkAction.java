package com.action;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeworkAction extends ActionSupport{
//	private static final long serialVersionUID = 1L;
//	private File uploadFile; 
//	private String uploadFileFileName; 
//	private String uploadFileContentType; 
//	private String path;	 
//	private String filename;
//	//从下载文件原始存放路径读取得到文件输出流 
//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
//	
//	public String getFilename() {
//		return filename;
//	}
//
//	public void setFilename(String filename) {
//		this.filename = filename;
//	}
//
//
//	public File getUploadFile() {
//		return uploadFile;
//	}
//
//	public void setUploadFile(File uploadFile) {
//		this.uploadFile = uploadFile;
//	}
//
//	public String getUploadFileFileName() {
//		return uploadFileFileName;
//	}
//
//	public void setUploadFileFileName(String uploadFileFileName) {
//		this.uploadFileFileName = uploadFileFileName;
//	}
//
//	public String getUploadFileContentType() {
//		return uploadFileContentType;
//	}
//
//	public void setUploadFileContentType(String uploadFileContentType) {
//		this.uploadFileContentType = uploadFileContentType;
//	}
//
//	public String upLoad() throws Exception {
//	
//		if (uploadFile == null)
//			return "error";
//		String serverRealPath = ServletActionContext.getServletContext()
//				.getRealPath("/upload/homework") + "\\" + uploadFileFileName;
//		File homeworkFile = new File(serverRealPath);
//		FileUtils.copyFile(uploadFile, homeworkFile);
//		String dateBasepath = "/upload/homework/" + uploadFileFileName;
//		
//		ActionContext context=ActionContext.getContext();
//		HttpServletRequest request=ServletActionContext.getRequest();
//		String id=request.getParameter("id");
//		Integer uid=(Integer)context.getSession().get("id");	
//		HomeworkDao.saveHomework(Integer.parseInt(id), dateBasepath, uploadFileFileName, uid);
//		
//		int size=10;
//		int pagecode=1;
//	
//		List<Exercise> lst=HomeworkDao.GetHomeworkList(pagecode, size);
//		int num=HomeworkDao.GetExerciseSize();
//		int pages=num/size;
//		if(num%size!=0)
//		{
//			pages++;
//		}
//		context.put("lst", lst);
//		request.setAttribute("pagecode", pagecode);
//		request.setAttribute("pages", pages);
//		return "homeworklist";
//	}
//
//
//	public java.io.InputStream getDownloadFile()throws Exception {
//	InputStream in= ServletActionContext.getServletContext().getResourceAsStream(getPath());	
//	 return in;
//	 
//	}
//
//	public String homeworkDownload() throws Exception {
//		// TODO Auto-generated method stub
//		HttpServletRequest request=ServletActionContext.getRequest();
//		String id=request.getParameter("id");
//		Exercise exercise=HomeworkDao.getExercise(Integer.parseInt(id));
//		filename=exercise.getName();
//		path=exercise.getPath();
//		return SUCCESS;
//	}
//	@Override
//	public String execute() throws Exception {
//		// TODO Auto-generated method stub
//		return SUCCESS;
//	}
//	public String showHomeworkList() throws Exception {
//		HttpServletRequest request=ServletActionContext.getRequest();
//		String pagecode=request.getParameter("pagecode");
//		int size=10;
//		
//		ActionContext context=ActionContext.getContext();	
//		List<Exercise> lst=HomeworkDao.GetHomeworkList(Integer.parseInt(pagecode), size);
//		int num=HomeworkDao.GetExerciseSize();
//		
//		int pages=num/size;
//		if(num%size!=0)
//		{
//			pages++;
//		}
//		
//		context.put("lst", lst);
//		request.setAttribute("pagecode", Integer.parseInt(pagecode));
//		request.setAttribute("pages", pages);
//		return "homeworklist";
//	}
//	
//	
}
