<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
</head>
<body>

	商品名：${param.gname }<br/>
	商品价格：${param.gprice }<br/>
	商品所属类别：${param.ctype }<br/>
	<img alt="" src="<%=basePath %>/images/${param.gpic}"/><br/>
	
	<c:url value="/ForderSer" var="buy">
		<c:param name="status" value="buy" />
		<c:param name="gid" value="${param.gid}" />
		<c:param name="gname" value="${param.gname}" />
		<c:param name="gprice" value="${param.gprice}" />
	</c:url>
	
	<a href="${buy}">购买</a>

</body>
</html>