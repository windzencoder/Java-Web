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

	<s:form action="employee_save" method="post" namespace="/" id="saveForm" theme="simple">
		<table border='0' cellpadding="0" cellspacing="10">

			<tr>
				<td>姓名：</td>
				<td><s:textfield name="name"></s:textfield> </td>
				<td>性别：</td>
				<td><s:radio name="sex" list="{'男', '女'}"></s:radio> </td>
			</tr>
			
			<tr>
				<td>用户名：</td>
				<td><s:textfield name="username"></s:textfield> </td>
				<td>密码：</td>
				<td><s:textfield name="password"></s:textfield> </td>
			</tr>
			
			<tr>
				<td>出生日期：</td>
				<td><s:textfield name="birthday" type="date"></s:textfield></td>
				<td>入职日期：</td>
				<td><s:textfield name="joinDate" type="date"></s:textfield></td>
			</tr>

			<tr>
				<td>所属部门：</td>
				<td><s:select name="department.did" list="list"  listKey="did" listValue="dname" headerKey="" headerValue="请选择"></s:select></td>
				<td>编号：</td>
				<td><s:textfield name="eno"></s:textfield></td>
			</tr>
		</table>
	</s:form>


</body>
</html>