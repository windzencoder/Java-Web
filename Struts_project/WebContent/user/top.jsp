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

  </head>
  
  <body style="margin-top:0px;" bgcolor="#5EC4F7">
   <TABLE WIDTH="772" BORDER="0" height="80"  align="center" CELLPADDING="0" CELLSPACING="0">
	<TR>
		<TD WIDTH="238" HEIGHT="79" valign="top">
			<img border="0" src="image/main/logo1.gif" width="239" height="80">
		</TD>
		<TD WIDTH="68" HEIGHT="79">
        	<a href="#">
				<img border="0" src="image/main/top01.gif" width="68" height="80" alt="站点首页"/>
			</a>
		</td>
		<td WIDTH="80" HEIGHT="79">
			<a href="#">
				<img border="0" src="image/main/top02.gif" width="80" height="80" alt="技术论坛"/>
			</a>
		</td>
		<td WIDTH="80" HEIGHT="79">
		
			<a href="#">
				<img border="0" src="image/main/top03.gif" width="80" height="80" alt="企业建站"/>
			</a>
		</td>
		<td WIDTH="78" HEIGHT="79">
			<a href="#">
				<img border="0" src="image/main/top04.gif" width="78" height="80" alt="主机域名"/>
			</a>
		</td>
		<td WIDTH="83" HEIGHT="79">
			<a href="#">
				<img border="0" src="image/main/top05.gif" width="83" height="80" alt="免费服务"/>
			</a>
		</td>
		<td WIDTH="80" HEIGHT="79">
			<a href="#">
		     	<img border="0" src="image/main/top06.gif" width="80" height="80" alt="欢迎加入"/>
			</a>
		 </td>
		<td WIDTH="65" HEIGHT="79">
			<a href="#">
				<img border="0" src="image/main/top07.gif" width="65" height="80" alt="客户留言">
			</a>
		</td>
		</TD>
	</TR>
	</TABLE>
  </body>
</html>
