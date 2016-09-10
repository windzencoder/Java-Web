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
		<base href="<%=basePath%>">

		<title>My JSP 'editad.jsp' starting page</title>

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
	font-size: 18px;
}

.style3 a {
	color: #6A5ACD;
	font-size: 16px;
}

.style4 {
	font-size: 12px;
	color: #295568;
}

#txtarea {
	width: 100%;
	height: 100px;
}

#pic {
	font-size: 14px;
	color: #283439;
	height: 30px;
	width: 200px;
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
											<span class="style1">首页编辑</span>
										</td>
										<td></td>

									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<s:form action="firstpage" name="frm" enctype="multipart/form-data">


						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="1" bgcolor="#e1e2e3">


							<tr height="100px">

								<td bgcolor="#ffffff" width="40%" align="right">

									<div class="style3" style="margin-right: 20px">
										修改内容:
									</div>
								</td>
								<td bgcolor="#ffffff">
									<s:textarea value="%{#request.firstpage.description}"
										name="content" theme="simple" id="txtarea"></s:textarea>
								</td>
							</tr>
							<tr>
								<td bgcolor="#ffffff" colspan="2">
									<input type="hidden" value="${requestScope.firstpage.id}"
										name="id" />
									<input type="hidden" value="1" name="pagecode" />
									<div align="center" class="style3">


										<s:submit type="image" src="images/admin/submit.png"
											onclick="return check();" id="sub" method="saveFirstpage"
											theme="simple" />
										<a href="javascript:history.go(-1);"> <img
												src="images/tupian/houtui.png" /> </a>
									</div>
								</td>

							</tr>


						</table>
					</s:form>
				</td>
			</tr>
		</table>

	</body>
</html>
