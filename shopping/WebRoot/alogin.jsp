<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="<%=basePath %>/AccountSer" method="post">
		登录名：<input name="alogin"  type="text" /></br>
		密码：<input name="apass"  type="password" /></br>
		${error}</br>
		<input  type="submit" value="提交"/>
		<input  type="hidden" name="status" value="login"/>
	</form>
</body>
</html>