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

  </head>
  
  <body style="margin-top: 0px;">
<div align="center">
	<table border="0" width="773" cellspacing="0" cellpadding="0" height="31" background="image/main/hengMenuBG.jpg">
		<tr>
			<td width="595">
				<p align="left">您还没有登陆，请先
				<a href="http://www.mbsky.com/bbs/login.asp">登陆</a>
				或
				<a href="http://www.mbsky.com/bbs/register.asp">注册</a>！
			</td>
			<td width="183">
				<p align="center">　
			</td>
		</tr>
	</table>
	
	<s:form>
		<s:submit value="ok"></s:submit>
	</s:form>
	<button>hello</button>
</div>
  </body>
</html>
