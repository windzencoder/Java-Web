<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	font-size: 12px;
}

#navigation {
	margin: 0px;
	padding: 0px;
	width: 147px;
}

#navigation a.head {
	cursor: pointer;
	background: url(images/main_34.gif) no-repeat scroll;
	display: block;
	font-weight: bold;
	margin: 0px;
	padding: 5px 0 5px;
	text-align: center;
	font-size: 12px;
	text-decoration: none;
}

#navigation ul {
	border-width: 0px;
	margin: 0px;
	padding: 0px;
	text-indent: 0px;
}

#navigation li {
	list-style: none;
	display: inline;
}

#navigation li li a {
	display: block;
	font-size: 12px;
	text-decoration: none;
	text-align: center;
	color: #6A5ACD;
	padding: 3px;
}

#navigation li li a:hover {
	background: url(images/tab_bg.gif) repeat-x;
	border: solid 1px #adb9c2;
}
</style>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/chili-1.7.pack.js"></script>
<script type="text/javascript" src="./js/jquery.easing.js"></script>
<script type="text/javascript" src="./js/jquery.dimensions.js"></script>
<script type="text/javascript" src="./js/jquery.accordion.js"></script>
<script language="javascript">
	jQuery().ready(function(){
		jQuery('#navigation').accordion({
			header: '.head',
			navigation1: true, 
			event: 'click',
			fillSpace: true,
			animated: 'bounceslide'
		});
	});
   </script>
</head>

<body>

	<div style="height: 100%;">

		<ul id="navigation">
			<li><a class="head">用户管理</a>
				<ul>
					<li>
						<a href="useraction!showUserList.action" target="rightFrame">用户列表</a>
					</li>
				</ul>
			</li>
			<li>
				<a class="head">首页管理</a>
				<ul>
					<li><a href="firstpage!adminShowFirstPage.action" target="rightFrame">修改首页</a></li>
				</ul>
			</li>
			<li>
				<a class="head">教师管理</a>
				<ul>
					<li><a href="adminteacher!getTeacher.action" target="rightFrame">教师资料</a></li>
				</ul>
			</li>
			<li>
				<a class="head">教学资源管理</a>
				<ul>
					<li><a href="adminppt!showPptList.action" target="rightFrame">课件列表</a></li>

					<li><a href="referbook!showBookList" target="rightFrame">参考书籍介绍</a></li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>
