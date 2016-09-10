<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>后台管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



<script type="text/javascript">
	function form_submit(){
		document.getElementById("login").submit();
	}
	function form_reset(){
		document.getElementById("login").reset();
	}
	</script>
<style type="text/css">
body {
	background-image: url("<%=basePath %>images/login_11.gif");
	background-color: white;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>

</head>
<body>

	<div align="center">

		<s:form action="admin" id="login" theme="simple">
			<table>
				<tr>
					<td background="images/login_07.gif" height="84px">
						<table>
							<tr height="30px">
								<td>用户名：</td>
								<td><input type="text" name="name" /></td>
							</tr>
							<tr height="30px">
								<td>密&nbsp; &nbsp;码：</td>
								<td><input type="password" name="pwd" /></td>
							</tr>
						</table>
					</td>
					<td height="84px">
						<div id="center_middle_right"></div>
					</td>
					<td background="images/login_09.gif" height="84px">
						<table style="margin-top: 0px;">
							<!-- 提交按钮 -->
							<s:submit type="image" src="images/dl.gif" id="id_log" method="adminLogin">
							</s:submit>
						</table> 
						<!-- 重置按钮 -->
						<img src="images/cz.gif" width="60" height="20" onclick="form_reset()" style="margin-left: 3px; margin-top: 6px;">
					</td>


				</tr>
			</table>

		</s:form>

	</div>


</body>
</html>