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

		<title>用户列表</title>

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

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			
			<!-- 显示的图片 索引 -->
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
											<span class="style1">学生列表</span>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<!-- 添加用户 列表 -->
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr height="50px" >
							<td bgcolor="d3eaef" align="right" colspan="4" >
								<div style="margin-right:20px;">
									<s:a action="useraction" method="toAddUser">
									添加用户
									</s:a>
								</div>
							</td>
						</tr>
						
						<!-- 列表头 -->
						<tr>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									编号
								</div>
							</td>
							<td bgcolor="d3eaef" align="center" width="200px">
								<div class="style2">
									学号
								</div>
							</td>

							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									名字
								</div>
							</td>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									操作
								</div>
							</td>
						</tr>
						
						<%
							
							int num = 1;
						%>

						<!-- 循环获取用户 -->
						<s:iterator var="user" value="#request.userlist">
						
								<tr>
									<td bgcolor="#ffffff" align="center">
										<div class="style3"><%=num++%></div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#user.num"></s:property>
										</div>
									</td>

									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#user.name"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
										
											<!-- 尝试另一种写法 -->
											<!--  
											<s:a action="useraction" method="delUser">
												删除
												<s:param name="id">${user.id}</s:param>
											</s:a>
											-->
											<a href="${pageContext.request.contextPath}/useraction!delUser?id=${user.id}">删除</a>
											
										</div>
									</td>
								</tr>
						
						</s:iterator>
					</table>
				</td>
			</tr>

		
		</table>
		</td>
		</tr>

		</table>

	</body>
</html>
