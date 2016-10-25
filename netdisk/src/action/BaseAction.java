package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.javafx.collections.MappingChange.Map;

import common.UserInfo;
import service.ServiceManager;

/*
 * 基础动作类
 */
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	protected ServiceManager serviceManager;
	//封装UserInfo对象的属性
	protected UserInfo userInfo;
	//封装处理结果属性
	protected String result;
	protected Map<String, String> cookies;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		//给UserInfo对象的cookieUser和userRoot属性赋值
		userInfo.setCookieUser(getCookieValue("user"));
		userInfo.setUserRoot(userInfo.getRoot() + userInfo.getCookieUser());
	}

	//返回一个指定的Cookie值
	protected String getCookieValue(String name) {
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (!cookie.getName().equals(name)) {
					continue;
				}
				return cookie.getValue();
			}
		}
		return null;
	}

	/**
	 * result属性的getter方法
	 */
	public String getResult() {
		return result;
	}

	/**
	 * result属性的setter方法
	 */
	public void setResult(String result) {
		this.result = result;

	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	/**
	 * userInfo属性的setter方法
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;

	}

	//保存Cookie
	protected void saveCookie(String name, String value, int maxAge) {
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(name, value);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
}
