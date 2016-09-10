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

		<title>My JSP 'itemlist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
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
	font-size: 14px;
}

.style3 {
	color: #344b50;
	font-size: 18px;
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

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30px" width="80%">
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
											<span class="style1">教师信息</span>
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
							<td bgcolor="#ffffff" align="right" width="50%">
								<div class="style2">
									名字：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.name"></s:property>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									性别：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.sex"></s:property>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									学位：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.degree"></s:property>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									职位：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.position"></s:property>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									教育背景：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.eduBackground"></s:property>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									学院：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.college"></s:property>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									联系地址：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.address"></s:property>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									研究方向：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.direction"></s:property>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									简介：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.intro"></s:property>
								</div>
							</td>
						</tr>
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									学术成就：
								</div>
							</td>
							<td bgcolor="#ffffff" align="left">
								<div class="style2">
									<s:property value="#teacher.achievement"></s:property>
								</div>
							</td>
						</tr>
			
						<tr>
							<td bgcolor="#ffffff" align="right">
								<div class="style2">
									照片：
								</div>
							</td>
							<td bgcolor="#ffffff" align="center" width="150px" height="120px">
								<div class="style3">
									<img src="<s:property value='#teacher.photo'/>" height="110px" width="140px" />
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2" bgcolor="#ffffff">
								<div align="center" class="style3">
									<a href="javascript:history.go(-1);"><img
											src="images/tupian/houtui.png" />
									</a>
									<s:a action="adminteacher" method="correct">
										<img src="images/tupian/xiugai.jpg" />
										<s:param name="teacherid" value="{#teacher.id}"/>
									</s:a>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>

		</table>

	</body>
</html>
