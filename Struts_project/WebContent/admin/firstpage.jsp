<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="./js/uploadDialog.js"></script>

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
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}

.style1 {
	color: #e1e2e3;
	font-size: 12px;
}

.style2 {
	color: #000000;
	font-size: 12px;
}

.style3 {
	color: #344b50;
	font-size: 12px;
}

.style3 a {
	color: #6A5ACD;
}

.style4 {
	font-size: 12px;
	color: #295568;
}
</style>
	</head>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="30px" width="100%">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td bgcolor="#353c44" width="100%" height="24px">
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td width="18px" valign="bottom">
										<img src="images/tb.gif" width="14px" height="14px" />
									</td>
									<td valign="bottom">
										<span class="style1">首页管理</span>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="1"
					bgcolor="#a8c7ce">
					<tr>
						<td></td>
						<td></td>
						<td bgcolor="#a8c7ce" align="right">
							<div class="style3">
								<s:a action="firstpage" method="modifyfirstpage">
									修改主页文本内容
									<s:param name="id">1</s:param>
								</s:a>
								
							</div>
						</td>
					</tr>
					<tr>
						<td bgcolor="d3eaef" align="center" width="600" colspan="3">
							<div class="style2">
								内容
							</div>
						</td>
					
					</tr>
						<tr>
							<td bgcolor="#ffffff" align="left" rowspan="10" valign="top" colspan="3">
								<div class="style3">
									<s:property value="#firstpage.description"></s:property>
								</div>
							</td>
							</tr>
						
				</table>
			</td>
		</tr>

		<tr>
		<tr>
			<td height="30px;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				</table>
			</td>

		</tr>
	</table>
	<body>

	</body>
</html>
