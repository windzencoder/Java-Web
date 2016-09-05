<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String basePath = request.getContextPath();
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ basePath;
%>
<html>
<head></head>
<body>
	<table border="0" width="600px">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">添加员工</td>
		</tr>
		<tr>
			<td align="right"><a
				href="javascript:document.getElementById('saveForm').submit()">保存</a>
				&nbsp;&nbsp; <a href="javascript:history.go(-1)">退回</a></td>
		</tr>
	</table>
	<br />

	<s:form action="employee_update" method="post" namespace="/" id="saveForm" theme="simple">
		<!-- 影藏字段 -->
		<s:hidden name="eid" value="%{model.eid}"></s:hidden>
		<table border='0' cellpadding="0" cellspacing="10">

			<tr>
				<td>姓名：</td>
				<td><s:textfield name="name" value="%{model.name}"></s:textfield> </td>
				<td>性别：</td>
				<td><s:radio name="sex" list="{'男', '女'}" value="%{model.sex}"></s:radio> </td>
			</tr>
			
			<tr>
				<td>用户名：</td>
				<td><s:textfield name="username" value="%{model.username}"></s:textfield> </td>
				<td>密码：</td>
				<td><s:textfield name="password" value="%{model.password}" showPassword="true"></s:textfield> </td>
			</tr>
			
			<tr>
				<td>出生日期：</td>
				<td><input type="date" name="birthday" value='<s:date name="model.birthday" format="yyyy-MM-dd"/>' /></td>
				<td>入职日期：</td>
				<td><input type="date" name="joinDate" value='<s:date name="model.joinDate" format="yyyy-MM-dd"/>' /></td>
			</tr>

			<tr>
				<td>所属部门：</td>
				<td><s:select name="department.did" list="list"  value="%{model.department.did}" listKey="did" listValue="dname" headerKey="" headerValue="请选择"></s:select></td>
				<td>编号：</td>
				<td><s:textfield name="eno" value="%{model.eno}"></s:textfield></td>
			</tr>
		</table>
	</s:form>


</body>
</html>