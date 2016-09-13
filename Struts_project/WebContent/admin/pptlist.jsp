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

		<title>ppt列表页面</title>

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
											<span class="style1">课件列表</span>
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
							<td></td>
							<td></td>
							<td>
								<s:a action="adminppt" method="addPpt" align="right">
									<div class="style2">
										添加新课件
									</div>
								</s:a>
							</td>
						</tr>
						<tr>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									编号
								</div>
							</td>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									课件名称
								</div>
							</td>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									发布时间
								</div>
							</td>
							<td bgcolor="d3eaef" align="center">
								<div class="style2">
									下载查看
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
						
						<!-- 循环 -->
						<s:iterator var="ppt" value="#lst">
							<tr>
								<td bgcolor="#ffffff" align="center">
									<div class="style3"><%=num++%></div>
								</td>
								<td bgcolor="#ffffff" align="center">
									<div class="style3">
										<s:property value="#ppt.name"></s:property>
									</div>
								</td>
								<td bgcolor="#ffffff" align="center">
									<div class="style3">
										<s:property value="#ppt.date"></s:property>
									</div>
								</td>
								
								<!-- 下载 -->
								<td bgcolor="#ffffff" align="center">
									<div class="style3">
										<s:a action="adminppt" method="pptDownload">下载
											<s:param name="id">
												<s:property value="#ppt.id"/>
											</s:param>
										</s:a>
									</div>
								</td>
								<!-- 删除 -->
								<td bgcolor="#ffffff" align="center">
									<div class="style3">
										<s:a action="adminppt" method="delPpt">删除
											<s:param name="pptid">
												<s:property value="#ppt.id"/>
											</s:param>
										</s:a>
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
