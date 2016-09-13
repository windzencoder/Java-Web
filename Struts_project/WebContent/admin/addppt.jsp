<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

		<script language="javascript" type="text/javascript"
			src="./js/WdatePicker.js"></script>
		<script src="./js/js.js"></script>
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
	background-color: #f6f6Ff;
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
	font-size: 18px;
}

.style3 a {
	color: #6A5ACD;
}
</style>

	</head>

	<body>
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
											<span class="style1">添加电子课件</span>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="1" bgcolor="#e1e2e3">
			<tr height="50px">
				<td bgcolor="#ffffff" width="50%" align="right">
					<div class="style3">
						上传课件：
					</div>
				</td>
				<td bgcolor="#ffffff">
					<div class="style5">
						<!-- 上传ppt -->
						<s:form action="adminppt.action" enctype="multipart/form-data" method="post">
							<s:file name="ppt" label="选择文件" />
							<s:submit value="上传"  method="savePpt" />
						</s:form>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
