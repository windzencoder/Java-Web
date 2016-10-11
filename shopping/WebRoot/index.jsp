<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String basePath = request.getContextPath();
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>淘宝</title>
</head>
<body>

	<c:choose>
		<c:when test="${sessionScope.users==null }">
			您好目前您的状态是游客，请<a href="<%=path %>/ulogin.jsp">登录</a>
		</c:when>
		<c:otherwise>
			您好，${sessionScope.users.uname}，<a href="#">退出</a>
		</c:otherwise>
	</c:choose>

	<c:forEach items="${applicationScope.bigList}" var="list">

		<table width="700px" height="200" border="1">
			<tr>
				<!-- 类别名字 -->
				<td height="25" colspan="4">${list[0].category.ctype}</td>
			</tr>
			<tr>
				<c:forEach items="${list}" var="goods">
					<td width="150px" height="165" valign="top">
						<table width="100%">
							<tr>
								<td><img alt="图片" src="<%=basePath %>/images/${goods.gpic}">
								</td>
							</tr>
							<tr>
								<td>${goods.gprice}</td>
							</tr>
							<tr>
								<td>
									${goods.gname}
									<c:url value="/detail.jsp" var="detail">
										<c:param name="gid" value="${goods.gid}" />
										<c:param name="gname" value="${goods.gname}" />
										<c:param name="gprice" value="${goods.gprice}" />
										<c:param name="gpic" value="${goods.gpic}" />
										<c:param name="ctype" value="${goods.category.ctype}" />
									</c:url> 
									<a href="${detail}" target="_blank">详细</a>
								</td>
							</tr>
						</table>
					</td>
				</c:forEach>
			</tr>
		</table>
		</c:forEach>

</body>
</html>