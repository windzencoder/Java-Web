<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/top.css">


  </head>
  
  <body>

   
<table width="100%" border="0" bordercolor="#ff0000" cellspacing="0" cellpadding="0">


			<tr>
				<td height="57" background="images/main_03.gif">
					<table width="100%" border="0" bordercolor="#00ff00" cellpadding="0" cellspacing="0">
						<tr>
						
							<td width="378" height="57" background="images/top_.jpg">
								&nbsp;
							</td>
							
							<td>
								&nbsp;
							</td>
							<td width="281" valign="bottom">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="33" height="27">
											<img src="images/main_05.gif" width="33" height="27" />
										</td>
										<td width="248" background="images/main_06.gif">
											<table width="225" border="0" align="center" cellpadding="0"
												cellspacing="0">
												<tr>
												
												
													<td>
														<div align="right">
														<!-- 退出 -->
															<s:a action="admin" method="exit" target="_parent">
															<img src="images/quit.gif" alt=" " width="69" height="17" />
															</s:a>
														</div>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>

				</td>
			</tr>
<!-- 下一行 -->
			<tr>
				<td height="40" background="images/main_10.gif">
			 
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
						
							<td width="194" height="40" background="images/main_07.gif">
								&nbsp;
							</td>
							
							
							
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
									<!-- 首页 -->
										<td width="21">
										
											        <img src="images/main_13.gif" width="19" height="14" />
											
										</td>
										<td width="35" class="STYLE7">
											<div align="center">
											
												<s:a action="../loginaction!showindexpage" target="rightFrame">首页</s:a>
												
												
											</div>
										</td>
										<!--  后退-->
										<td width="21" class="STYLE7">
											<img src="images/main_15.gif" width="19" height="14" />
										</td>
										<td width="35" class="STYLE7">
											<div align="center">
												<a href="javascript:history.go(-1);">后退</a>
											</div>
										</td>
										<!-- 前进 -->
										<td width="21" class="STYLE7">
											<img src="images/main_17.gif" width="19" height="14" />
										</td>
										<td width="35" class="STYLE7">
											<div align="center">
												<a href="javascript:history.go(1);">前进</a>
											</div>
										</td>
										<!-- 刷新 -->
										<td width="21" class="STYLE7">
											<img src="images/main_19.gif" width="19" height="14" />
										</td>
										<td width="35" class="STYLE7">
											<div align="center">
												<a href="javascript:window.parent.location.reload();">刷新</a>
											</div>
										</td>
										
										
										<td>
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
							
							<td  width="248px">&nbsp;</td>
							
						</tr>
					</table>
				</td>
			</tr>



<!-- 最后一行 -->


			<tr>

				<td height="30" background="images/main_31.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
						
							<td width="8" height="30">
								<img src="images/main_28.gif" width="8" height="30" />
							</td>
							
							<td width="147" background="images/main_29.gif">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="24%">
											&nbsp;
										</td>
										<td width="43%" height="20" valign="bottom" class="STYLE1">
											<font color="#0000">管理菜单</font>
										</td>
										<td width="33%">
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
							
							<td width="39">
								<img src="images/main_30.gif" width="39" height="30" />
							</td>
							
							<td>
							     <table> 
							         <tr>
							               <td><font color="#0">当前登录用户：</font></td>
							               <td>
							                  <font color="#0">
							                    <s:property value="#session.name"/>
							                    </font>
							                </td>
							                <td><font color="#0">&nbsp;用户角色：</font></td>
							                <td><font color="#0"> ${sessionScope.role} </font></td>
							         </tr>
							         
							    </table>
							</td>
							
							<td width="17">
								<img src="images/main_32.gif" width="17" height="30" />
							</td>
							
						</tr>
					</table>
				</td>
			</tr>


		</table>
   
   
   
  </body>
</html>
