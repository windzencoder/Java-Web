package action;

import javax.servlet.http.Cookie;

public class ReloginAction extends BaseAction
{
    
	public String execute() throws Exception
	{
		try
		{
			Cookie cookie = new Cookie("JSESSIONID", "");
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);			
			return SUCCESS;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
}