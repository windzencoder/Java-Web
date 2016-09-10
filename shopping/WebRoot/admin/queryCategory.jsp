<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询类别</title>
</head>
<body>
	<form action="<%=basePath %>/CategorySer" method="post">
		查询：<input name="ctype" type="text" /><br/>
		<input type="submit" value="提交">
		<input type="hidden" value="queryCategory" name="status" />
	</form>
	<c:if test="${requestScope.categories != null}">
		<table border="1">
			<tr>
				<td>编号</td>
				<td>类别名</td>
				<td>是否热点</td>
				<td>所属客服</td>
			</tr>
			<c:forEach items="${requestScope.categories}" var="category" varStatus="num">
				<tr>
					<td>${num.count}</td>
					<td>${category.ctype}</td>
					<td>
						<c:choose>
							<c:when test="${category.chot == true}">
								<input type="checkbox" checked="checked" value="true" disabled="disabled"/>
							</c:when>
							<c:otherwise>
								<input type="checkbox"  value="true" disabled="disabled"/>
							</c:otherwise>
						</c:choose>
					</td>
					<td>${category.account.aname}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>