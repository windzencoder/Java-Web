<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<LINK rel="stylesheet" type="text/css" href="css/default.css">
<style type="text/css">
	.mycenter{
		margin:0 auto;
		border: 1px solid #ff0000;
		text-align: center;
	}
</style>
  </head>
  
  <body style="margin-top: 0px;">
  	<div id="mycenter" align="center">
		<iframe src="user/left.jsp" name="left" width="161px" scrolling="no"/>
		<iframe src="user/right.jsp" name="right" width="611px"/>
	</div>
  </body>
</html>
