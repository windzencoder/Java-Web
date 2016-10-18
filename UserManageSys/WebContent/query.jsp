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
<title>显示用户信息</title>
</head>
<body>
	<h1>用户信息</h1>
	<table border="1" width="400">
		<tr>
			<th>用户ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>用户类型</th>
			<th>是否删除</th>
			<th>是否修改</th>
		</tr>
		<s:iterator value="#request.userlist" id="st">
			<tr>
				<td><s:property value="#st.id"/></td>
				<td><s:property value="#st.name"/></td>
				<td><s:property value="#st.password"/></td>
				<td><s:property value="#st.type"/></td>
				<!-- 定义超链接 -->
				<td><a href="<%=path %>/user/deleteuser.action?id=<s:property value='#st.id' />">删除</a></td>
				<td><a href="<%=path %>/update.jsp?id=<s:property value='#st.id' />">更新</a></td>
			</tr>
		</s:iterator>
	</table>
	
	<br/>
	
	<a href="<%=path %>/save.jsp">添加用户</a>
	
</body>
</html>