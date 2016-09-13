package com.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dao.PptDao;
import com.model.Ppt;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 课件Action
 */
public class PptAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String path;	 
	private String filename;
	
	private File ppt;//上传的文件
	private String pptFileName;//上传的文件名
	
	//下载的InputStream
	private InputStream fileInputStream;
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	
	 
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getFilename() {
		//文件名
		try {
			filename = new String(filename.getBytes(), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}  
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

	//InputStream流代表了被下载文件的入口
//	public java.io.InputStream getDownloadFile()throws Exception {
//		InputStream in= ServletActionContext.getServletContext().getResourceAsStream(getPath());
//		System.out.println("inputStream:----- " + in);
//	 return in;
//	 
//	}
	
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/*
	 * 下载ppt
	 */
	public String pptDownload() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		//通过id获取到ppt
		Ppt ppt=PptDao.GetPpt(Integer.parseInt(id));
		filename=ppt.getName();
		path=ppt.getPath();
		
		//设置inputStream
		fileInputStream = ServletActionContext.getServletContext().getResourceAsStream(getPath());
		
		return SUCCESS;
	}
	
	/*
	 * 展示ppt列表
	 */
	public String showPptList() throws Exception {
		ActionContext context=ActionContext.getContext();	
		//获取ppt列表
		List<Ppt> lst=PptDao.GetPptList();
		context.put("lst", lst);
		return "pptlist";// /admin/pptlist.jsp 页面
	}
	
	/*
	 * 删除ppt
	 */
	public String delPpt() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("pptid");
	
		//这里并没有删除文件？
		
		//获取ppt
		Ppt ppt = PptDao.GetPpt(Integer.valueOf(id));
		if (ppt != null) {
			String pptPath = ServletActionContext.getServletContext().getRealPath(ppt.getPath());
			//删除文件
			File targetFile = new File(pptPath); 
            if (targetFile.isDirectory()) { 
                    FileUtils.deleteDirectory(targetFile); 
            } else if (targetFile.isFile()) { 
                    targetFile.delete(); 
            } 
		}
		
		
		//删除数据库中的数据
		PptDao.deletePpt(Integer.parseInt(id));
		
		ActionContext context=ActionContext.getContext();	
		List<Ppt> lst=PptDao.GetPptList();
		context.put("lst", lst);
		
		return "pptlist";
	}
	
	/*
	 * 添加新ppt 跳转的页面
	 */
	public String addPpt() throws Exception {
		return "addppt"; ///admin/addppt.jsp
	}
	
	/*
	 * 保存ppt
	 */
	public String savePpt()throws Exception{
		if (ppt == null){
			return "error";
		}
		//在服务器上的路径 复制到服务器
		String serverRealPath = ServletActionContext.getServletContext()
				.getRealPath("/upload/ppt") + "/" + pptFileName;
		File uploadFile = new File(serverRealPath);
		FileUtils.copyFile(ppt, uploadFile);
		
		//保存路径在数据库
		String dateBasepath = "/upload/ppt/" + pptFileName;
		PptDao.savePpt(pptFileName, dateBasepath);
		
		//查询列表
		ActionContext context=ActionContext.getContext();	
		List<Ppt> lst=PptDao.GetPptList();
		context.put("lst", lst);
		
		return "pptlist";
	}
	
}
