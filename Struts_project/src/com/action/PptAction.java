package com.action;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dao.PptDao;
import com.model.Ppt;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PptAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String path;	 
	private String filename;
	private File ppt;
	private String pptFileName;

	//从下载文件原始存放路径读取得到文件输出流 
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	public File getPpt() {
		return ppt;
	}

	public void setPpt(File ppt) {
		this.ppt = ppt;
	}

	public String getPptFileName() {
		return pptFileName;
	}

	public void setPptFileName(String pptFileName) {
		this.pptFileName = pptFileName;
	}


	public java.io.InputStream getDownloadFile()throws Exception {
	InputStream in= ServletActionContext.getServletContext().getResourceAsStream(getPath());
	 
	
	 return in;
	 
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	public String pptDownload() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		Ppt ppt=PptDao.GetPpt(Integer.parseInt(id));
		filename=ppt.getName();
		path=ppt.getPath();
		return SUCCESS;
	}
	public String showPptList() throws Exception {
		// TODO Auto-generated method stub
	
		ActionContext context=ActionContext.getContext();	
		List<Ppt> lst=PptDao.GetPptList();
		context.put("lst", lst);
		
		return "pptlist";
	}
	public String delPpt() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("pptid");
		PptDao.deletePpt(Integer.parseInt(id));
		
		ActionContext context=ActionContext.getContext();	
		List<Ppt> lst=PptDao.GetPptList();
		context.put("lst", lst);
		
		return "pptlist";
	}
	public String addPpt() throws Exception {
		return "addppt";
	}
	public String savePpt()throws Exception{
		if (ppt == null)
			return "error";
		String serverRealPath = ServletActionContext.getServletContext()
				.getRealPath("/upload/ppt") + "\\" + pptFileName;
		File uploadFile = new File(serverRealPath);
		FileUtils.copyFile(ppt, uploadFile);
		String dateBasepath = "/upload/ppt/" + pptFileName;
		PptDao.savePpt(pptFileName, dateBasepath);
		
		ActionContext context=ActionContext.getContext();	
		List<Ppt> lst=PptDao.GetPptList();
		context.put("lst", lst);
		
		return "pptlist";
	}
	
}
