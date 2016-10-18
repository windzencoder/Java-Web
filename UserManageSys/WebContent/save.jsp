<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>	
	<s:form action="adduser" method="post" namespace="/user">
		<h1><s:text name="欢迎注册"></s:text> </h1>
		<s:property value="exception.message" />
		<s:textfield name="user.name" key="用户名" tooltip="Enter your name!" required="true"></s:textfield>
		<s:textfield name="user.password" key="密码" tooltip="Enter your password!" required="true"></s:textfield>
		<s:textfield name="user.type" key="类型" tooltip="Enter your type!" required="true"></s:textfield>
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>