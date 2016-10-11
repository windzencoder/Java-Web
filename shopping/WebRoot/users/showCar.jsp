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
<title>购物车</title>
</head>
<body>
	这里显示购物车：也就是购买商品的列表显示
	<table border="1">
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品数量</td>
			<td>删除</td>
		</tr>
		
		
		<c:choose>
			<c:when test="${sessionScope.forder.sorders.size() == 0 }">
				<tr>购物车已经清空</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${sessionScope.forder.sorders}" var="sorder">
					<tr>
						<td>${sorder.goods.gid }</td>
						<td>${sorder.sname }</td>
						<td>${sorder.sprice }</td>
						<td><input type="text" value="${sorder.snumber }"/></td>
						<td>
							<a href="<%=path %>/ForderSer?status=deleteSorder&gid=${sorder.goods.gid}">删除</a> 
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		

		
	</table>
	
	<a href="<%=path %>/ForderSer?status=deleteForder">清空购物车</a> <span>|</span>
	<a href="<%=path %>">继续购物</a>
	<div>总价：${sessionScope.forder.ftotal}</div>
	
	<a href="<%=path%>/users/forderInfo.jsp">提交订单</a>
	

</body>
</html>