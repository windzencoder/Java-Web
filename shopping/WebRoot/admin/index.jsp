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

	<frameset rows="100, *" frameborder="yes">
		<frame src="<%=basePath %>/admin/top.jsp"/>
		<frameset cols="150, *" frameborder="yes">
			<frame src="<%=basePath %>/admin/left.jsp"/>
			<frame src="<%=basePath %>/admin/main.jsp" name="right"/>
		</frameset>
	</frameset>

</html>