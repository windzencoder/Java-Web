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
<title>修改用户信息</title>
</head>
<body>
	<s:form action="updateuser" method="post" namespace="/user">
		<h1><s:text name="修改用户信息"></s:text> </h1>
		<s:textfield name="user.id" key="用户ID" required="true"></s:textfield>
		<s:textfield name="user.name" key="用户名" required="true"></s:textfield>
		<s:textfield name="user.password" key="密码" required="true"></s:textfield>
		<s:textfield name="user.type" key="密码" required="true"></s:textfield>
		<s:submit value="提交"></s:submit>
		<s:reset value="重置"></s:reset>
	</s:form>
</body>
</html>