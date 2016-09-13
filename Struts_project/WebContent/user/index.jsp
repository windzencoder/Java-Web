<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>软件工程</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


<!-- ajax的标签 -->
<sx:head />

<style type="text/css">
a:Link {
	color: #208000;
	font-family: "Tahoma,宋体";
	font-weight: 700;
	font-size: 20px;
	text-decoration: none;
}

a:visited {
	color: #208000;
	font-family: "Tahoma,宋体";
	font-weight: 700;
	font-size: 20px;
	text-decoration: none;
}

a:hover {
	color: #208000;
	font-family: "Tahoma,宋体";
	font-weight: 700;
	font-size: 20px;
	text-decoration: underline;
}

a:active {
	color: #208000;
	font-family: "Tahoma,宋体";
	font-weight: 700;
	font-size: 20px;
	text-decoration: none;
}

a {
	color: #208000;
	font-weight: 700;
	font-size: 20px;
	text-decoration: none;
}

#status {
	margin-top: 0px;
}

#top {
	
}

#main {
	width: 772px;
	border: 1px solid;
	margin: 0px auto;
}

#footer {
	width: 772px;
	margin: 0px auto;
	height: 60px;
}

#login {
	border-bottom: 1px solid;
	height: 160px;
}

#right {
	margin-top: 0px;
	border-left: 1px solid;
	height: 100%;
}
</style>
<script type="text/javascript">
	
	function checklogin(){
		var user=document.getElementById("user");
		if(user==null)
		{
			alert("请先登录");	
			return false;
		}	
		return true;
	}
	window.onload=function showfirst()
	{
		var first=document.getElementById("first");
		first.click();
	}
	
</script>
</head>
<body style="margin-top: 0px;" bgcolor="#c0c0ff ">
	<div id="top">
		<TABLE WIDTH="772" BORDER="0" height="79" align="center"
			CELLPADDING="0" CELLSPACING="0" bgcolor="#a8c7ce">
			<tr>
				<td WIDTH="68" align="center">
				
				<!-- firstpage Action 通过 js调用 -->
				<s:a target="rightFrame" action="firstpage.action" id="first">
							首页
					</s:a>
				</td>
				<td WIDTH="80" align="center">
					<s:a target="rightFrame" action="userteacher!getTeacher.action">
							教师介绍
					</s:a></td>
				<td WIDTH="80" align="center"><s:a target="rightFrame"
						action="referbook!userShowBookList">
							相关书籍
					</s:a></td>
				<td WIDTH="78" align="center"><s:a target="rightFrame" action="userppt!showPptList.action?pagecode=1">
							电子教程
					</s:a></td>
			</TR>
		</TABLE>
	</div>

	<div id="status">
		<table align="center" border="0" width="773" cellspacing="0"
			cellpadding="0" height="31" background="image/main/hengMenuBG.jpg">
			<tr>
				<td width="595">
					<p align="left">欢迎访问软件工程学习网站！
				</td>
				<td width="183">
					<p align="center">
				</td>
			</tr>
		</table>
	</div>
	<div id="main">
		<table border="0" cellpadding="0" cellspacing="0" height="600px">
			<tr>
				<!-- 登录页面 -->
				<td width="161px" align="left" valign="top">

					<div id="login">
						<jsp:include page="login.jsp"></jsp:include>
					</div>
				</td>
				<!-- 课程介绍 -->
				<td width="612px">

					<div id="right">
						<iframe id="rightFrame" src="user/first.jsp" name="rightFrame"
							width="100%" frameborder="0" height="0" scrolling="no"
							onload="document.all['rightFrame'].style.height=rightFrame.document.body.scrollHeight"></iframe>

					</div>

				</td>
			</tr>
		</table>
	</div>
	<div id="footer">
		<TABLE align="center" BORDER="0" CELLPADDING="0" CELLSPACING="0"
			WIDTH="100%" HEIGHT="100%" bgcolor="#FFFFFF">
			<TR>
				<TD background="image/main/FooterCopyrightBG.jpg">
					<P ALIGN="center">版权所有&copy;
				</TD>
		</TABLE>
	</div>
</body>
</html>
