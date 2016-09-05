<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String basePath = request.getContextPath();
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ basePath;
%>
<html>
<head>
<style type="text/css">
.table1 {
	border: 1px solid #ddd;
	width: 900px;
}

thead {
	background-color: lightblue;
}
</style>
</head>
<body>
	<table border="0" width="900px">
		<tr>
			<td align="center" style="font-size: 24px; color: #666">员工管理</td>
		</tr>
		<tr>
			<td align="right">
				<a href="${pageContext.request.contextPath}/employee_saveUI.action">添加</a>
			</td>
		</tr>
	</table>
	<br />
	<table cellspacing="0" border="1" class="table1">
		<thead>
			<tr>
				<th width="450">编号</th>
				<th width="450">员工姓名</th>
				<th width="450">性别</th>
				<th width="450">出生日期</th>
				<th width="450">入职时间</th>
				<th width="450">所属部门</th>
				<th width="450">编辑</th>
				<th width="450">删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="list" var="e">
				<tr>
					<td align="center"><s:property value="#e.eno"/></td>
					<td align="center"><s:property value="#e.name"/></td>
					<td align="center"><s:property value="#e.sex"/></td>
					<td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/> </td>
					<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"/></td>
					<td align="center"><s:property value="#e.department.dname"/></td>
					<td align="center">
						<a href="${pageContext.request.contextPath}/employee_edit.action?eid=<s:property value="#e.eid"/>"><img src="${pageContext.request.contextPath}/images/eidt.png"></a>
					</td>
					<td align="center">
						<a href="${pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="#e.eid"/>"><img src="${pageContext.request.contextPath}/images/delete.png"></a>
					</td>
				</tr>
			</s:iterator>

		</tbody>
	</table>
	<br />


	<table border="0" cellspacing="0" cellpadding="0" width="900px">
		<tr>
			<td align="right">
				<span>第<s:property value="currPage" />/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
				<span>总记录数：<s:property value="totalCount"/></span>&nbsp;&nbsp;
				<span>每页显示：<s:property value="pageSize" /></span>&nbsp;&nbsp;
				
				<span> 
				<s:if test="currPage != 1">
					<a href="${pageContext.request.contextPath}/employee_findAll?currPage=1">[首页]</a>&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/employee_findAll?currPage=<s:property value="currPage-1" />">[上一页]</a>&nbsp;&nbsp;
				</s:if>
				<s:if test="currPage != totalPage">
					<a href="${pageContext.request.contextPath}/employee_findAll?currPage=<s:property value="currPage+1" />">[下一页]</a>&nbsp;&nbsp;
					<a href="${pageContext.request.contextPath}/employee_findAll?currPage=<s:property value="totalPage" />">[尾页]</a>&nbsp;&nbsp; 
				</s:if>
				</span>
			</td>
		</tr>
	</table>
</body>
</html>