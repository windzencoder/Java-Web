<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
	String basePath=request.getContextPath(); 
	String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单信息</title>
</head>
<body>
	此次购物订单信息如下：

	<table border="1">
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品数量</td>
		</tr>

		<c:forEach items="${sessionScope.forder.sorders}" var="sorder">
			<tr>
				<td>${sorder.goods.gid }</td>
				<td>${sorder.sname }</td>
				<td>${sorder.sprice }</td>
				<td>${sorder.snumber }</td>
			</tr>
		</c:forEach>


	</table>

	<div>总价：${sessionScope.forder.ftotal}</div>
	
	<br/>
	
	-------------------------------
	
	<br>
	
	配送信息填写：<br/>
	<form action="<%=path %>/ForderSer" method="post">
		收货人姓名：<input type="text" name="fname" value="${sessionScope.users.uname }" /><br/>
		电话：<input type="text" name="fphone" value="${sessionScope.users.uphone }" /><br/>
		Email：<input type="text" name="femail" value="${sessionScope.users.uemail }" /><br/>
		邮编：<input type="text" name="fpost" value="${sessionScope.users.upost }" /><br/>
		留言：<input type="text" name="fremark" value="" /><br/>
		<input type="submit" value="确认提交" /><br/>
		<input type="hidden" name="status" value="saveForder" />
	</form>

</body>
</html>