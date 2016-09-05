<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getContextPath();
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ basePath;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
</head>

<frameset rows="90,*" >
	<frame  src="${pageContext.request.contextPath}/frame/top.jsp" scrolling="no" >
   <frameset id="main" cols="170,*">
      <%-- <frame src="${pageContext.request.contextPath}/frame/left1.jsp" scrolling="no">  --%>
      <frame src="${pageContext.request.contextPath}/frame/left.jsp" scrolling="no"> 
      <%-- <frame src="${pageContext.request.contextPath}/frame/left2.jsp" scrolling="no">  --%>
      
      <frame name="right" src="${pageContext.request.contextPath}/frame/right.jsp" scrolling="no">
   </frameset>
   <%-- <frame src="${pageContext.request.contextPath}/frame/control.jsp" scrolling="no"> --%>
   
</frameset>


</html>