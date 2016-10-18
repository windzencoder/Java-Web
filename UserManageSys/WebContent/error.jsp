<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>未成功登录</title>  
  </head> 
  <body>
    错误，请注册！ <br>
    <a href="<%=path %>/save.jsp">用户注册</a>
  </body>
</html>
