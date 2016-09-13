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
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

  	<div style="float: left;">
		<TABLE id="UserLogon" BORDER="0" CELLPADDING="0" CELLSPACING="0"
			WIDTH="100%" class="LeftPanelLine_Top">
			
			<TR>
				<TD CLASS="PanelBG_1" ALIGN="center" VALIGN="top">
				
					<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="161"
						height="110">
						<TR>
							<TD WIDTH="172" HEIGHT="110">
								<s:form action="log" method="post" theme="simple">																		
									<p align="center">
										用户名:
										<s:textfield name="no" size="8" theme="simple"/>										
										<br>
										<br>
										密  码:
										<s:password name="pwd" size="8" theme="simple"/>
										
										<br>
										<br>
										<!-- 异步提交 -->
										<sx:submit value="登录" method="login" targets="login" ></sx:submit>
										&nbsp;&nbsp;
										<INPUT type=reset value=取消 name=Submit>
									</p>
									
								</s:form>
							</TD>
						</TR>
					</TABLE>
					
				</TD>
			</TR>
			</form>
		</TABLE>
		
		</div>
	
	</body>
</html>
