<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师介绍</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#content{
			margin-top:5px;
		}
	</style>
  </head> 
  <body>
  	<div id="content">
  	 <table border="0" cellpadding="0" cellspacing="0" width="100%">
  	   <tr>
  	   		<td>
  	   			<table border="0" cellpadding="0" cellspacing="0">
  	   			<tr height="40px">
  	 				<td width="100px">
  	 				<font color="#003399">姓名：</font>
  	 				
  	 				</td>
  	 				<td>
  	 					<s:property value="#teacher.name"/>
  	 				</td>
  	 			</tr>
  	 			<tr height="40px">
  	 				<td>
  	 				
  	 				<font color="#003399">性别：</font></td>
  	 				<td>
  	 				<s:property value="#teacher.sex"/>
  	 				</td>
  	 			</tr>
  	 			<tr  height="40px">
  	 				<td>
  	 				<font color="#003399">职位：</font></td>
  	 				<td>
  	 					<s:property value="#teacher.position"/>
  	 				</td>
  	 			</tr>
  	 			<tr height="40px">
  	 				<td>
  	 				<font color="#003399">教育背景：</font></td>
  	 				<td>
  	 				<s:property value="#teacher.eduBackground"/>
  	 				</td>
  	 			</tr>
  	 			<tr height="40px">
  	 				<td>
  	 				<font color="#003399">学院：</font></td>
  	 				<td>
  	 					<s:property value="#teacher.college"/>
  	 				</td>
  	 			</tr>
  	 			<tr height="40px">
  	 				<td>
  	 				<font color="#003399">联系地址：</font>
  	 				</td>
  	 				<td>
  	 				<s:property value="#teacher.address"/>
  	 				</td>
  	 			</tr height="40px">
  	 	   			
  	   			</table>
  	   		
  	   		</td>
  	   		<!-- 图片  -->
  	   		<td valign="top">
  	   			<img src="<s:property value='#teacher.photo'/>" width="180px" height="180px">
  	   		</td>
  	   </tr>

			<tr>
				<td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr height="40px">
							<td width="100px">
								<font color="#003399">简介：</font>
							</td>
							<td>
								<s:property value="#teacher.intro" />
							</td>
						</tr>
						
						<tr height="40px">
							<td>
								<font color="#003399">学术成就：</font>
							</td>
							<td>
								<s:property value="#teacher.achievement" />
							</td>
						</tr>

						<tr height="40px">
							<td>
								<font color="#003399">研究方向：</font>
							</td>
							<td>
								<s:property value="#teacher.direction" />
							</td>
						</tr>

					</table>
				</td>
			</tr>


		</table>
		</div>
  </body>
</html>
