package com.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.dao.TeacherDao;
import com.model.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private File uploadPhoto; // 用户上传的照片文件
	private String uploadPhotoFileName; // 上传文件的文件名

	

	public File getUploadPhoto() {
		return uploadPhoto;
	}

	public void setUploadPhoto(File uploadPhoto) {
		this.uploadPhoto = uploadPhoto;
	}

	public String getUploadPhotoFileName() {
		return uploadPhotoFileName;
	}

	public void setUploadPhotoFileName(String uploadPhotoFileName) {
		this.uploadPhotoFileName = uploadPhotoFileName;
	}
	public String correctTeacher() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
	
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String degree = request.getParameter("degree");
		String position = request.getParameter("position");
		String eduBackground = request.getParameter("eduBackground");
		String college = request.getParameter("college");
		String address = request.getParameter("address");
		String direction = request.getParameter("direction");
		String intro = request.getParameter("intro");
		String achievement = request.getParameter("achievement");
		
//		
//		
//		upLoadPhoto();
		
		if (uploadPhoto == null)
			return "error";
		//picFileName=new Date().toLocaleString();
		String serverRealPath = ServletActionContext.getServletContext()
				.getRealPath("/upload/teacher") + "\\" + uploadPhotoFileName;
		File picFile = new File(serverRealPath);
		FileUtils.copyFile(uploadPhoto, picFile);
		
		
		
		String path = "upload/teacher/" + uploadPhotoFileName;
		
		//String path = new String("d:\\upload\\photo" + uploadPhoto);
		
		Teacher teacher = TeacherDao.getTeacher();
		teacher.setAchievement(achievement);
		teacher.setAddress(address);
		teacher.setCollege(college);
		teacher.setDegree(degree);
		teacher.setDirection(direction);
		teacher.setEduBackground(eduBackground);

		teacher.setIntro(intro);
		teacher.setName(name);
		teacher.setPosition(position);
		teacher.setSex(sex);
		teacher.setPhoto(path);
		
		
		
		ActionContext actioncontext = ActionContext.getContext();
		TeacherDao.InsertTeacher(teacher);
		
		ActionContext context=ActionContext.getContext();
		teacher=TeacherDao.getTeacher();
		context.put("teacher", teacher);
		return SUCCESS;
	
	}
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	public String getTeacher() throws Exception {
		ActionContext context=ActionContext.getContext();
		Teacher teacher=TeacherDao.getTeacher();
		context.put("teacher", teacher);
		return SUCCESS;
	}
	public String correct() throws Exception {
		
		return "correct";
	}
}
