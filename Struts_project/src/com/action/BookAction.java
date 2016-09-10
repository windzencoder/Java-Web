package com.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dao.BookDao;
import com.model.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{

	
	
	
	private static final long serialVersionUID = 1L;
	private File pic; //
	private String picFileName; // 
	private String picContentType; 
	
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public String getPicFileName() {
		return picFileName;
	}
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public String getPicContentType() {
		return picContentType;
	}
	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	/*
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	public String showBookList()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String pagecode=request.getParameter("pagecode");
		int size=10;
		
		ActionContext context=ActionContext.getContext();		
		
		
		
		List<Book> lst=BookDao.GetBookList(Integer.parseInt(pagecode), size);
		int num=BookDao.GetBookSize();
		int pages=num/size;
		if(num%size!=0)
		{
			pages++;
		}
		context.put("lst", lst);
		request.setAttribute("pagecode", Integer.parseInt(pagecode));
		request.setAttribute("pages", pages);
		
		
		
//		context.put("pagecode", "1");
//		context.put("pages", "3");
		
		return "booklist";
	}
	public String gotoAddBook()throws Exception{		
		return "gotoaddbook";
	}
	
	public String saveBook()throws Exception{
	//	FileUtils.copyFile(srcFile, destFile)
		if (pic == null)
			return "error";
		//picFileName=new Date().toLocaleString();
		String serverRealPath = ServletActionContext.getServletContext()
				.getRealPath("/upload/book") + "\\" + picFileName;
		File picFile = new File(serverRealPath);
		FileUtils.copyFile(pic, picFile);
		
		
		
		String dateBasepath = "upload/book/" + picFileName;
	//ServletActionContext.getRequest().getContextPath() + "/
		System.out.println("address:-------------"+dateBasepath);
		HttpServletRequest request=ServletActionContext.getRequest();
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		Book book=new Book();
		book.setDescription(description);
		book.setName(name);
		book.setPath(dateBasepath);
		book.setStatus("1");
		BookDao.saveBook(book);
		
		int pagecode=1;
		int size=10;
		
		ActionContext context=ActionContext.getContext();		
		
		
		
		List<Book> lst=BookDao.GetBookList(pagecode, size);
		int num=BookDao.GetBookSize();
		int pages=num/size;
		if(num%size!=0)
		{
			pages++;
		}
		context.put("lst", lst);
		request.setAttribute("pagecode",pagecode);
		request.setAttribute("pages", pages);
		
		
		
//		context.put("pagecode", "1");
//		context.put("pages", "3");
		
		return "booklist";
	}
	public String modifyBook()throws Exception{
		//	FileUtils.copyFile(srcFile, destFile)
			ActionContext context=ActionContext.getContext();
			HttpServletRequest request=ServletActionContext.getRequest();
			String id=request.getParameter("bookid");
			
			
			Book book=BookDao.getBook(Integer.parseInt(id));
			context.put("book", book);

			
			return "gotomodifybook";
		}
	public String saveModifyBook()throws Exception{
		//	FileUtils.copyFile(srcFile, destFile)
		
		
			HttpServletRequest request=ServletActionContext.getRequest();
			String id=request.getParameter("id");
			
			
			Book book=BookDao.getBook(Integer.parseInt(id));
			
			
			String name=request.getParameter("name");
			String description=request.getParameter("description");
			if(pic!=null){
				//picFileName=new Date().toLocaleString();
				String serverRealPath = ServletActionContext.getServletContext()
						.getRealPath("/upload/book") + "\\" + picFileName;
				File picFile = new File(serverRealPath);
				FileUtils.copyFile(pic, picFile);
				String dateBasepath = ServletActionContext.getRequest()
						.getContextPath() + "/upload/book/" + picFileName;
				book.setPath(dateBasepath);
			}
		
			
			
			
			book.setDescription(description);
			book.setName(name);
		
			book.setStatus("1");
			BookDao.updateook(book);
			
			int pagecode=1;
			int size=10;
			
			ActionContext context=ActionContext.getContext();		
			
			
			
			List<Book> lst=BookDao.GetBookList(pagecode, size);
			int num=BookDao.GetBookSize();
			int pages=num/size;
			if(num%size!=0)
			{
				pages++;
			}
			context.put("lst", lst);
			request.setAttribute("pagecode", pagecode);
			request.setAttribute("pages", pages);
			
			
			
//			context.put("pagecode", "1");
//			context.put("pages", "3");
			
			return "booklist";
		}
	public String deleteBook()throws Exception{
		//	FileUtils.copyFile(srcFile, destFile)
			ActionContext context=ActionContext.getContext();
			HttpServletRequest request=ServletActionContext.getRequest();
			String id=request.getParameter("bookid");
			BookDao.deleteBook(Integer.parseInt(id));
			int pagecode=1;
			int size=10;
			
	
			
			
			List<Book> lst=BookDao.GetBookList(pagecode, size);
			int num=BookDao.GetBookSize();
			int pages=num/size;
			if(num%size!=0)
			{
				pages++;
			}
			context.put("lst", lst);
			request.setAttribute("pagecode", pagecode);
			request.setAttribute("pages", pages);
			
			
			
//			context.put("pagecode", "1");
//			context.put("pages", "3");
			
			return "booklist";
		}
	
	
	/*
	 * 
	 * user 
	 */
	public String userShowBookList()throws Exception{
		ActionContext context=ActionContext.getContext();		
		List<Book> lst=BookDao.GetBookList();
		context.put("lst", lst);
		
		return "userbooklist";
	}

	public String showBookList()throws Exception{
		ActionContext context=ActionContext.getContext();		
		List<Book> lst=BookDao.GetBookList();	
		context.put("lst", lst);	
		return "booklist";
	}
	public String modifyBook()throws Exception{
		//	FileUtils.copyFile(srcFile, destFile)
			ActionContext context=ActionContext.getContext();
			HttpServletRequest request=ServletActionContext.getRequest();
			String id=request.getParameter("bookid");
			
			
			Book book=BookDao.getBook(Integer.parseInt(id));
			context.put("book", book);

			
			return "gotomodifybook";
		}
	public String deleteBook()throws Exception{
		
			ActionContext context=ActionContext.getContext();
			HttpServletRequest request=ServletActionContext.getRequest();
			String id=request.getParameter("bookid");
			BookDao.deleteBook(Integer.parseInt(id));
			List<Book> lst=BookDao.GetBookList();	
			context.put("lst", lst);	
			return "booklist";
		}
	public String saveModifyBook()throws Exception{
		//	FileUtils.copyFile(srcFile, destFile)
		ActionContext context=ActionContext.getContext();
		
			HttpServletRequest request=ServletActionContext.getRequest();
			String id=request.getParameter("id");
			
			
			Book book=BookDao.getBook(Integer.parseInt(id));
			
			
			String name=request.getParameter("name");
			String description=request.getParameter("description");
			if(pic!=null){
				//picFileName=new Date().toLocaleString();
				String serverRealPath = ServletActionContext.getServletContext()
						.getRealPath("/upload/book") + "\\" + picFileName;
				File picFile = new File(serverRealPath);
				FileUtils.copyFile(pic, picFile);
				String dateBasepath = ServletActionContext.getRequest()
						.getContextPath() + "/upload/book/" + picFileName;
				book.setPath(dateBasepath);
			}
			
			
			
			
			book.setDescription(description);
			book.setName(name);
	
			BookDao.updatebook(book);
			
			List<Book> lst=BookDao.GetBookList();	
			context.put("lst", lst);	
			return "booklist";
		}
	public String gotoAddBook()throws Exception{		
		return "gotoaddbook";
	}
	public String saveBook()throws Exception{
		//	FileUtils.copyFile(srcFile, destFile)
			if (pic == null)
				return "error";
			//picFileName=new Date().toLocaleString();
			String serverRealPath = ServletActionContext.getServletContext()
					.getRealPath("/upload/book") + "\\" + picFileName;
			File picFile = new File(serverRealPath);
			FileUtils.copyFile(pic, picFile);
			
			
			
			String dateBasepath = "upload/book/" + picFileName;
		
			HttpServletRequest request=ServletActionContext.getRequest();
			String name=request.getParameter("name");
			String description=request.getParameter("description");
			Book book=new Book();
			book.setDescription(description);
			book.setName(name);
			book.setPath(dateBasepath);
			
			BookDao.savebook(book);
			
			ActionContext context=ActionContext.getContext();	
			List<Book> lst=BookDao.GetBookList();	
			context.put("lst", lst);	
			return "booklist";
		}
}
