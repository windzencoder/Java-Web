<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录成功页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<sx:head />
  </head>
  
  <body>

  	<div style="float: left;">
		<TABLE id="UserLogon" BORDER="0" CELLPADDING="0" CELLSPACING="0"
			WIDTH="100%" class="LeftPanelLine_Top">
			<TR>
				<TD VALIGN="top" HEIGHT="36" ALIGN="center">
					<img border="0" src="image/main/userlogin.gif" width="161" height="36">
				</TD>
			</TR>
			<TR>
				<TD CLASS="PanelBG_1" ALIGN="center" VALIGN="top">
				
					<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="161"
						height="110">
						<TR>
							<TD WIDTH="61px" HEIGHT="60" align="center">
										用户名:
							</TD>
							<td width="100px" align="left">
								<s:property value="#user.name"/>	
							</td>
						</TR>
						<tr height="50px">
							<td align="center" valign="top">
								学  号:
							</td>
							<td align="left" valign="top">
								<s:property value="#user.num"/>
								<s:hidden id="user" value="#session.id"></s:hidden>
							</td>
						</tr>
					</TABLE>
					
				</TD>
			</TR>
			</form>
		</TABLE>
		
		</div>
	
	</body>
</html>
