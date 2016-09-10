<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=basePath %>/CategorySer" method="post">
		类别名：<input name="ctype" type="text" /><br/>
		是否热点：<input name="chot" type="checkbox" value="true" /><br/>
		<input type="submit" value="提交">
		<input type="hidden" value="saveCategory" name="status" />
	</form>
</body>
</html>